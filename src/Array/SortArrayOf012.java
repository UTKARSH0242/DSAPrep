package Array;

// Class to sort an array containing only 0s, 1s, and 2s using the Dutch National Flag Algorithm
public class SortArrayOf012 {
    // Main method: Entry point of the program
    public static void main(String[] args) {
        // Initialize an array with 0s, 1s, and 2s
        int[] arr = {0, 1, 2, 0, 1, 2};
        // Print the original array using Arrays.toString for readable output
        System.out.println("Original array: " + java.util.Arrays.toString(arr));
        // Call the sortBy012 method to sort the array
        sortBy012(arr);
        // Print the sorted array
        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
    }

    // Method to sort the array containing 0s, 1s, and 2s using Dutch National Flag Algorithm
    private static void sortBy012(int[] arr) {
        // Get the length of the array
        int n = arr.length;
        // Initialize three pointers:
        // low: points to the next position where a 0 should be placed
        // mid: iterates through the array to process each element
        // high: points to the next position where a 2 should be placed
        int low = 0;
        int mid = 0;
        int high = n - 1;

        // Continue processing until mid pointer crosses high pointer
        while (mid <= high) {
            // Case 1: If the current element is 0
            if (arr[mid] == 0) {
                // Swap arr[mid] with arr[low] to place 0 in the correct position
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                // Increment low and mid pointers, as the element at low is now correct
                low++;
                mid++;
            }
            // Case 2: If the current element is 1
            else if (arr[mid] == 1) {
                // No swap needed, 1 is in the correct region, just move mid forward
                mid++;
            }
            // Case 3: If the current element is 2
            else {
                // Swap arr[mid] with arr[high] to place 2 in the correct position
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                // Decrement high pointer, as the element at high is now correct
                high--;
            }
        }
    }
}