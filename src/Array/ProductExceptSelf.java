package array;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        // Fixed: Use Arrays.toString to actually read the output
//        System.out.println("Basic Approach: " + Arrays.toString(productExceptSelf(nums)));
        System.out.println("Optimized Approach: " + Arrays.toString(productExceptSelfOptimized(nums)));
//        System.out.println("Brute Force" + Arrays.toString(productExceptSelfBrute(nums)));
    }

    private static int[] productExceptSelfBrute(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

         Arrays.fill(answer, 1);

         for(int i = 0; i < n; i++){
             for(int j = 0; j < n; j++){
                 if(i != j){
                     answer[i] *= nums[j];
                 }
             }
         }
         return answer;
    }

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProductFromStart = new int[n];
        int[] prefixProductFromEnd = new int[n];
        int[] res = new int[n]; 

        prefixProductFromStart[0] = nums[0];
        prefixProductFromEnd[n - 1] = nums[n - 1];

        // ERROR FIXED: Loop must start at 1, because index 0 is already set
        for (int i = 1; i < n; i++) {
            prefixProductFromStart[i] = prefixProductFromStart[i - 1] * nums[i];
        }

        // This loop was logically fine, but simplified for clarity
        for (int i = n - 2; i >= 0; i--) {
            prefixProductFromEnd[i] = prefixProductFromEnd[i + 1] * nums[i];
        }

        res[0] = prefixProductFromEnd[1];
        res[n - 1] = prefixProductFromStart[n - 2];

        for (int i = 1; i < n - 1; i++) {
            res[i] = prefixProductFromStart[i - 1] * prefixProductFromEnd[i + 1];
        }

        return res;
    }

    // O(1) Space Complexity (ignoring output array)
    public static int[] productExceptSelfOptimized(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // Step 1: Use 'res' array to store prefix products
        // res[i] will contain the product of all elements to the LEFT of i
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate suffix products on the fly and multiply with stored prefix
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            // res[i] already has prefix product. Multiply by suffix product (rightProduct)
            res[i] = res[i] * rightProduct;

            // Update rightProduct for the next iteration (moving left)
            rightProduct = rightProduct * nums[i];
        }

        return res;
    }
}