package binarySearch;

public class findMinInRotatedSortedArray {
    public static void main(String[] args) {
        int arr[] = {4,5,6,7,0,1,2};
        int n = arr.length;
        int min = findMin(arr, n);
        System.out.println(min);
    }

    private static int findMin(int[] arr, int n) {
        int low = 0;
        int high = n-1;
        while(low < high){
            int mid = (low+high)/2;
            if(arr[mid] > arr[high]){
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return arr[low];
    }
}
