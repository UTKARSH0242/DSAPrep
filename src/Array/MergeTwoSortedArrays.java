package array;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 0, 0, 0};
        int m = 3; // The number of actual elements in arr1
        int[] arr2 = {2, 5, 6};
        int n = 3; // The number of elements in arr2

        // Call the method
        merge(arr1, m, arr2, n);

        // Print the result to see if it worked
        System.out.println(Arrays.toString(arr1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; // End of actual data in nums1
        int j = n - 1; // End of nums2
        int k = m + n - 1; // End of nums1 capacity

        // Compare from the back to the front
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // If nums2 still has items, move them over
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
        // Note: We don't need a loop for 'i' because those
        // elements are already in the correct place in nums1.
    }
}