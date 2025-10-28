package array.slidingWindowAndTwoPointers;

import java.util.Scanner;

public class MaxFromCards {

    /**
     * Solves the problem using the sliding window/two-pointers concept.
     * Time Complexity: O(k)
     * Space Complexity: O(1)
     */
    private static int maxScore(int[] cardPoints, int k) {
        int lSum = 0; // Sum of cards picked from the left side
        int rSum = 0; // Sum of cards picked from the right side
        int maxSum = 0;
        int n = cardPoints.length;
        int rIdx = n - 1; // Start index for the rightmost card

        // 1. Calculate the sum when all k cards are taken from the left side
        for (int i = 0; i < k; i++) {
            lSum += cardPoints[i];
        }
        maxSum = lSum; // Initialize maxSum with the score of k left cards

        // 2. Iterate k times, each time swapping a left card for a right card
        // i goes from k-1 (the rightmost card in the initial k-left selection) down to 0
        for (int i = k - 1; i >= 0; i--) {

            // a. "Slide" one card from the left selection out
            lSum = lSum - cardPoints[i];

            // b. "Slide" one card from the right selection in
            rSum = rSum + cardPoints[rIdx];
            rIdx = rIdx - 1; // Move the right pointer one step inward

            // c. Update the maximum sum found so far
            maxSum = Math.max(maxSum, lSum + rSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of cards (n):");
        int n = scanner.nextInt();

        System.out.println("Enter the number of cards to pick (k):");
        int k = scanner.nextInt();

        // Input validation for k <= n
        if (k > n) {
            System.out.println("Error: The number of cards to pick (k) cannot be greater than the total number of cards (n).");
            scanner.close();
            return;
        }

        int[] cards = new int[n];
        System.out.println("Enter the card points:");
        for (int i = 0; i < n; i++) {
            cards[i] = scanner.nextInt();
        }

        int maxSum = maxScore(cards, k);
        System.out.println("\nThe maximum sum of card points is: " + maxSum);

        scanner.close();
    }
}