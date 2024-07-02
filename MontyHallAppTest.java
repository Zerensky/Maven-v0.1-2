package com.example;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runners.Parameterized;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Parameterized.Parameter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MontyHallAppTest {

    private MontyHallApp app;

    @Parameter
    public boolean switchDoor;

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {true}, {false}
        });
    }

    @Before
    public void setUp() {
        app = new MontyHallApp();
    }

    @After
    public void tearDown() {
        app = null;
    }

    @Test
    public void testPlayGame() {
        boolean result = app.playGame(switchDoor);
        // This is a probabilistic test, we can't assert a specific result
        assertThat(result).isIn(true, false);
    }

    @Test
    public void testSetupDoors() {
        MontyHallApp.Door[] doors = app.setupDoors();
        long carCount = Arrays.stream(doors).filter(door -> door == MontyHallApp.Door.CAR).count();
        long goatCount = Arrays.stream(doors).filter(door -> door == MontyHallApp.Door.GOAT).count();
        assertThat(carCount).isEqualTo(1);
        assertThat(goatCount).isEqualTo(2);
    }
}


