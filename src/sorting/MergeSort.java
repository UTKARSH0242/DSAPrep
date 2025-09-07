package sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] unsortedArray = {3, 1, 2, 4, 1, 5, 2, 6, 4};
        mergeSort(unsortedArray, 0, unsortedArray.length - 1);
        System.out.println(Arrays.toString(unsortedArray));
    }

    private static void mergeSort(int[] array, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return;
        }

        int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
        mergeSort(array, lowIndex, middleIndex);
        mergeSort(array, middleIndex + 1, highIndex);
        merge(array, lowIndex, middleIndex, highIndex);
    }

    private static void merge(int[] array, int lowIndex, int middleIndex, int highIndex) {
        int[] mergedArray = new int[highIndex - lowIndex + 1];
        int leftPointer = lowIndex;
        int rightPointer = middleIndex + 1;
        int mergedArrayIndex = 0;

        // Merge the two halves into the temporary array
        while (leftPointer <= middleIndex && rightPointer <= highIndex) {
            if (array[leftPointer] <= array[rightPointer]) {
                mergedArray[mergedArrayIndex++] = array[leftPointer++];
            } else {
                mergedArray[mergedArrayIndex++] = array[rightPointer++];
            }
        }

        // Copy remaining elements of the left half, if any
        while (leftPointer <= middleIndex) {
            mergedArray[mergedArrayIndex++] = array[leftPointer++];
        }

        // Copy remaining elements of the right half, if any
        while (rightPointer <= highIndex) {
            mergedArray[mergedArrayIndex++] = array[rightPointer++];
        }

        // Copy the sorted elements from the temporary array back to the original array
        System.arraycopy(mergedArray, 0, array, lowIndex, mergedArray.length);
    }
}