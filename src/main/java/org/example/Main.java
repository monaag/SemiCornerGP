package org.example;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Task 1
        // Create a Scanner object
            Scanner input = new Scanner(System.in);
            System.out.println("Enter number: ");
            // Check if the input is integer or not
        boolean again = true;
        while (again)
            try {
                // Read user input
                int number = Integer.parseInt(input.nextLine());
                // Check if the number is positive, negative or 0
                if (number > 0) {
                    System.out.println("The number " + number + " is positive");
                } else if (number < 0) {
                    System.out.println("The number " + number + " is negative");
                } else {
                    System.out.println("The number " + number + " is zero");
                }
                again = false;
            } catch (NumberFormatException e) {
                System.out.println("Not integer, please enter an integer!");
            }
        // Task 2
        System.out.println("--------------------------------------------");
        // Print the 10 numbers
        for (int i = 1; i <= 10 ; i++) {
            System.out.println("Number "+i);
        }
        // Task 3
        System.out.println("--------------------------------------------");
        int[] arr1 = {1,2,4};
        int[] arr2 = {1,4,2};
        // Sort the arrays
        int[] a1 = Arrays.stream(arr1).sorted().toArray();
        int[] a2 = Arrays.stream(arr2).sorted().toArray();
        // Check if the arrays are equals
        if (Arrays.equals(a1, a2)){
            System.out.println("Arrays a1 and a2 are equals");
        }else
            System.out.println("Arrays a1 and a2 aren't equals");
    }
}