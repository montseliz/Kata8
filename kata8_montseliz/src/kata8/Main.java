package kata8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static final Scanner INPUT = new Scanner(System.in);
    static final List<Integer> FLOORS = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
    public static void main(String[] args) throws InterruptedException {
        int menu;

        do {
            System.out.println("""
            Indicate if you want to use the elevator:
            1. Yes
            2. No""");
            menu = INPUT.nextInt();
            switch (menu) {
                case 1 -> userInputs();
                case 2 -> System.out.println("Have a nice day!");
                default -> System.out.println("Error, you must introduce 1 or 2");
            }
        } while (menu != 2);

    }

    public static void userInputs() throws InterruptedException {
        int initialFloor;
        int finalFloor;
        boolean invalidInput = false;

        do {
            System.out.println("Please, indicate the floor you are on:");
            initialFloor = INPUT.nextInt();
            if (FLOORS.contains(initialFloor)) {
                System.out.println("Indicate the floor you want to go to:");
                finalFloor = INPUT.nextInt();
                if (FLOORS.contains(finalFloor)) {
                    System.out.println("You are in floor... " + initialFloor);
                    Thread.sleep(1500);
                    elevator(initialFloor, finalFloor);
                    Thread.sleep(1500);
                    System.out.println("You arrived to floor... " + finalFloor + "\n");
                    Thread.sleep(1500);
                } else {
                    System.out.println("Error. You must indicate a valid final floor. Please, try again");
                    invalidInput = true;
                }
            } else {
                System.out.println("Error. You must indicate a valid initial floor. Please, try again");
                invalidInput = true;
            }
        } while (invalidInput);

    }

    public static void elevator(int initialFloor, int finalFloor) throws InterruptedException {
        int trip;

        if (initialFloor < FLOORS.size()) {
            trip = finalFloor - initialFloor;
        } else {
            trip = finalFloor + initialFloor;
        }

        System.out.println("CLOSING THE DOOR...");
        Thread.sleep(1500);
        System.out.println("You have travelled...");
        Thread.sleep(1500);
        System.out.println(trip + " floor/s");
        Thread.sleep(1500);
        System.out.println("OPENING THE DOOR...");

    }

}