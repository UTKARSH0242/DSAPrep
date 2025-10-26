package binarySearch;

public class FindPeakElement {

    // The Solution class you provided, now nested inside the main class for simplicity
    public static class Solution {
        /**
         * Finds a peak element in the array using Binary Search.
         * A peak element is an element strictly greater than its neighbors.
         * Time Complexity: O(log n)
         * Space Complexity: O(1)
         * @param nums The input array.
         * @return The index of one of the peak elements.
         */
        public int findPeakElement(int[] nums) {
            int left = 0, right = nums.length - 1;

            // The loop stops when left == right, and that index will be a peak.
            while (left < right) {
                // Calculate mid. Using (left + right) / 2 is safe here because
                // we're dealing with array indices that won't exceed Integer.MAX_VALUE.
                int mid = left + (right - left) / 2; // A safer way to prevent overflow, though (left + right) / 2 is fine for typical array sizes.

                // If the element at 'mid' is greater than its right neighbor (descending slope)
                if (nums[mid] > nums[mid + 1]) {
                    // A peak must be at 'mid' or to its left.
                    right = mid;
                }
                // If the element at 'mid' is less than or equal to its right neighbor (ascending/flat slope)
                else {
                    // The peak must be to the right of 'mid'. We can safely discard 'mid'.
                    left = mid + 1;
                }
            }

            // 'left' (or 'right') is the index of a peak element.
            return left;
        }
    }

    public static void main(String[] args) {
        // 1. Initialize the input array
        int arr [] = {1, 2, 1, 3, 5, 6, 4}; // Peaks are at index 1 (value 2) and index 5 (value 6)

        // 2. Create an instance of the Solution class
        Solution solution = new Solution();

        // 3. Call the findPeakElement method
        int peakIndex = solution.findPeakElement(arr);

        // 4. Print the result
        System.out.println("--- Find Peak Element Example ---");
        System.out.print("Input Array: [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.println("]");
        System.out.println("A Peak Element is found at Index: " + peakIndex);
        System.out.println("The Peak Value is: " + arr[peakIndex]);

        // Expected output for this array is Index 5 (Value 6) or Index 1 (Value 2).
        // This specific binary search implementation usually finds the first peak from the right-hand side of the array's "main slope."
        // For {1, 2, 1, 3, 5, 6, 4}, it finds index 5.
    }
}