package stack;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;
import java.util.TreeSet;
import java.util.function.Function;

/**
 * This class demonstrates three different approaches to solve the
 * "Previous Smaller Element" problem.
 * 1. Brute Force: O(n^2) - The simplest, most intuitive solution.
 * 2. Better Solution: O(n log n) - An improvement using a balanced binary search tree.
 * 3. Best/Optimal Solution: O(n) - The most efficient solution using a stack.
 */
public class PreviousSmallestNearestElement {

    public static void main(String[] args) {
        // --- Test with a small array to verify correctness ---
        int[] smallArr = {4, 5, 2, 10, 8};
        System.out.println("Original Small Array: " + Arrays.toString(smallArr));
        System.out.println("---------------------------------------------------------------------------------");
        executeAndMeasure("1. Brute Force (O(n^2))", smallArr, PreviousSmallestNearestElement::findPreviousSmallerBruteForce);
        executeAndMeasure("2. Better (O(n log n)) [INCORRECT LOGIC]", smallArr, PreviousSmallestNearestElement::findPreviousSmallerBetter);
        executeAndMeasure("3. Best (O(n))", smallArr, PreviousSmallestNearestElement::findPreviousSmallerBest);
        System.out.println("\nNote: The 'Better' solution is logically incorrect for this specific problem.");
        System.out.println("---------------------------------------------------------------------------------");


        // --- Benchmark with a large array to observe true performance scaling ---
        System.out.println("\nBenchmarking with a large array (n=20,000)...");
        int[] largeArr = generateRandomArray(20000);
        System.out.println("---------------------------------------------------------------------------------");

        // The Brute Force solution will be very slow on the large array, so we run it on a slightly smaller subset.
        int[] mediumArr = Arrays.copyOf(largeArr, 10000);
        executeAndMeasure("1. Brute Force (O(n^2))", mediumArr, PreviousSmallestNearestElement::findPreviousSmallerBruteForce);

        // The Better and Best solutions can handle the full large array.
        executeAndMeasure("2. Better (O(n log n)) [INCORRECT LOGIC]", largeArr, PreviousSmallestNearestElement::findPreviousSmallerBetter);
        executeAndMeasure("3. Best (O(n))", largeArr, PreviousSmallestNearestElement::findPreviousSmallerBest);
        System.out.println("---------------------------------------------------------------------------------");
    }

    /**
     * A helper method to execute a given solving function, measure its performance,
     * and print the results in a formatted way.
     * @param approachName The name of the solution approach being tested.
     * @param arr The input array.
     * @param solvingFunction A function that takes an int[] and returns an int[].
     */
    public static void executeAndMeasure(String approachName, int[] arr, Function<int[], int[]> solvingFunction) {
        long startTime = System.nanoTime();
        int[] result = solvingFunction.apply(arr);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        // We only print the result array for small inputs to avoid cluttering the console.
        String resultString = arr.length < 20 ? Arrays.toString(result) : "(Result omitted for large array)";

        System.out.printf("%-42s Result: %-35s | Time taken: %d nanoseconds%n",
                approachName, resultString, duration);
    }

    /**
     * Generates an array of a given size with random integers.
     */
    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size);
        }
        return arr;
    }

    /**
     * Approach 1: Brute Force using nested loops.
     * For each element, it iterates backward to find the first smaller element.
     * Time Complexity: O(n^2)
     * Space Complexity: O(1) (excluding space for the result array)
     */
    public static int[] findPreviousSmallerBruteForce(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int n = arr.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            result[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    result[i] = arr[j];
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Approach 2: A better solution using a TreeSet (Balanced Binary Search Tree).
     * NOTE: This approach has INCORRECT LOGIC for this problem. It finds the largest
     * of ALL previous elements that is smaller, not the NEAREST one. It is included
     * here purely for algorithmic complexity comparison.
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static int[] findPreviousSmallerBetter(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int n = arr.length;
        int[] result = new int[n];
        TreeSet<Integer> seenElements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            Integer smaller = seenElements.lower(arr[i]);
            result[i] = (smaller == null) ? -1 : smaller;
            seenElements.add(arr[i]);
        }
        return result;
    }

    /**
     * Approach 3: The best and most optimal solution using a Stack.
     * This is the CORRECT and most efficient algorithm for this problem.
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int[] findPreviousSmallerBest(int[] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return result;
    }
}
