/*
Project: Java Bubble Sort + Binary Search – Efficient Search Fundamentals
Author: Tyfanna Moulton

Description:
------------
This program demonstrates foundational algorithm skills in Java by:
1) sorting a user-provided dataset using Bubble Sort, and
2) locating a target value using Binary Search.

The program also prints the low, high, and mid indices during the search
to show how Binary Search reduces the search space each iteration.

These skills are foundational for efficient searching and data validation
tasks in security tooling and data analysis workflows.

Scope:
------
Developed for educational purposes to demonstrate sorting and searching
algorithms, structured logic, and input handling.
*/

import java.util.Scanner;

public class BubbleSortBinarySearch {

    public static void bubbleSort(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            for (int j = 1; j < (len - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int[] numbers = new int[11];

        System.out.println("Please enter 11 integers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Integer " + (i + 1) + ": ");
            numbers[i] = scan.nextInt();
        }

        System.out.print("\nWhat is the target number: ");
        int target = scan.nextInt();
        System.out.println();

        // Sort the dataset
        bubbleSort(numbers);

        System.out.print("The sorted set is: ");
        for (int value : numbers) {
            System.out.print(value + " ");
        }
        System.out.println("\n");

        // Binary search
        int low = 0;
        int high = numbers.length - 1;
        boolean found = false;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Trace output for learning/visibility
            System.out.println("Low  = " + low);
            System.out.println("High = " + high);
            System.out.println("Mid  = " + mid);
            System.out.println("Searching...\n");

            if (target == numbers[mid]) {
                found = true;
                break;
            } else if (target < numbers[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (found) {
            System.out.println("The target is in the set.");
        } else {
            System.out.println("The target is not in the set.");
        }

        scan.close();
    }
}
