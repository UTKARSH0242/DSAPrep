package array;

import java.util.ArrayList;
import java.util.List;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }


    public static List<Integer> findDisappearedNumbers(int[] nums) {
        // Step 1: Mark visited indices as negative
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1; // -1 because numbers are 1-indexed
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx]; // flip to negative = "visited"
            }
        }

        // Step 2: Collect indices that are still positive
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1); // +1 to convert back to 1-indexed
            }
        }
        return result;
    }
}
