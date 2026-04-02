package array;

public class NumberOfSteps {
    public static void main(String[] args) {
        int nums = 14;
        System.out.println(numberOfSteps(nums));
    }

    private static int numberOfSteps(int num) {
        if (num == 0) return 0;
        if (num % 2 == 0) return 1 + numberOfSteps(num / 2);
        return 1 + numberOfSteps(num - 1);
    }
}
