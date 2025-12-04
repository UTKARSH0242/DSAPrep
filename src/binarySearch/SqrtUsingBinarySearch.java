package binarySearch;

public class SqrtUsingBinarySearch {
    public static void main(String[] args) {
        long x = 2147395599;
        System.out.println(mySqrt(x));
    }

    public static long mySqrt(long x) {
        long left = 0;
        long right = x;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (mid * mid == x) {
                return mid;
            } else if (mid * mid < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
}
