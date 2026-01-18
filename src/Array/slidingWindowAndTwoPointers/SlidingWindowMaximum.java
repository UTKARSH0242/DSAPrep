package array.slidingWindowAndTwoPointers;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3};
        int k = 3;
        // The return type should match the input type usually, or int[]
        System.out.println(Arrays.toString(maxSlidingWindow(arr, k)));
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int [] result = new int[n-k+1];
        int ri = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i< n; i++){
            if(!queue.isEmpty() && queue.peek() == i-k){
                queue.poll();
            }

            while(!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            queue.offer(i);
            if(i >= k-1) {
                result[ri++] = nums[queue.peek()];
            }
        }
        return result;
    }
}