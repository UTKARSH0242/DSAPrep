package array;

public class ConcatenationOfArrays {
    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5};
        int n = nums.length;
        int [] ans = getConcatenation(nums, n);
        for (int an : ans) {
            System.out.print(an + " ");
        }
    }

    private static int[] getConcatenation(int[] nums, int n) {
        int [] ans = new int[2*n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i+n] = nums[i];
        }
        return ans;
    }
}
