package sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {64, 25, 12, 22, 11};
        // Call the method and store the returned sorted array
        int[] sortedArr = selectionSort(arr);
        System.out.println(Arrays.toString(sortedArr));
    }


    private static int[] selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        // Return the array after it has been sorted
        return arr;
    }
}