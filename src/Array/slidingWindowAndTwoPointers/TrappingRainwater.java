package array.slidingWindowAndTwoPointers;

public class TrappingRainwater {
    public static void main(String[] args) {
        int[] building = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(building));


    }

    private static int trap(int[] building) {
        int left = 0;
        int right = building.length - 1;

        int leftMax = 0;
        int rightMax = 0;
        int waterTrapped = 0;

wbrb        while(left < right){
            if (building[left] <= building[right]){
                if (building[left] >= leftMax){
                    leftMax = building[left];
                }else{
                    waterTrapped += leftMax - building[left];
                }
                left++;
            }else{
                if (building[right] >= rightMax){
                    rightMax = building[right];
                }else{
                    waterTrapped += rightMax - building[right];
                }
                right--;
            }
        }
        return waterTrapped;
    }
}
