package com.example;

import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class MontyHallAppNegativeTest {

    private final MontyHallApp app = new MontyHallApp();

    @Test
    public void testSetupDoorsNegative() {
        MontyHallApp.Door[] doors = app.setupDoors();
        long carCount = Arrays.stream(doors).filter(door -> door == MontyHallApp.Door.CAR).count();
        long goatCount = Arrays.stream(doors).filter(door -> door == MontyHallApp.Door.GOAT).count();
        
        // This should not happen
        assertThat(carCount).isNotEqualTo(0);
        assertThat(goatCount).isNotEqualTo(0);
    }

    @Test
    public void testPlayGameNegative() {
        boolean result = app.playGame(true);
        // Negative test to make sure it's not always returning false or true
        assertThat(result).isNotEqualTo(true);
    }
}
