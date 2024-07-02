package com.example;

public class MontyHallApp extends Game {

    public enum Door { GOAT, CAR }

    public Door[] setupDoors() {
        Door[] doors = { Door.GOAT, Door.GOAT, Door.CAR };
        shuffleArray(doors);
        return doors;
    }

    private void shuffleArray(Door[] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);
            Door temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    @Override
    public boolean playGame(boolean switchDoor) {
        Door[] doors = setupDoors();
        int chosenDoor = new Random().nextInt(3);

        int revealedDoor = -1;
        for (int i = 0; i < 3; i++) {
            if (i != chosenDoor && doors[i] == Door.GOAT) {
                revealedDoor = i;
                break;
            }
        }

        if (switchDoor) {
            for (int i = 0; i < 3; i++) {
                if (i != chosenDoor && i != revealedDoor) {
                    chosenDoor = i;
                    break;
                }
            }
        }

        return doors[chosenDoor] == Door.CAR;
    }
}

