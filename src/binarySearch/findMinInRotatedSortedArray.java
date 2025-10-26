package binarySearch;

public class findMinInRotatedSortedArray {
    public static void main(String[] args) {
        int nums[] = {4,5,6,7,0,1,2};
        int n = nums.length;
        int min = findMin(nums, n);
        System.out.println(min);
    }

    private static int findMin(int[] nums, int n) {
        int low = 0;
        int high = n-1;
        while(low < high){
            int mid = (low+high)/2;
            if(nums[mid] > nums[high]){
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }
}
