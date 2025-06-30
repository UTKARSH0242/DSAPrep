package Array;

public class SecondLargestAndSmallest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 7, 5};
        int n = arr.length;
        int secondMin = secondSmallest(arr, n);
        int secondMax = secondLargest(arr, n);
        System.out.println("Second smallest is "+secondMin);
        System.out.println("Second largest is "+secondMax);
    }

    private static int secondLargest(int[] arr, int n) {
        if (n<2){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > max){
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];

            }
        }

        return secondMax;
    }

    private static int secondSmallest(int[] arr, int n) {
        if (n<2){
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] < min){
                secondMin = min;
                min = arr[i];
            } else if (arr[i] < secondMin && arr[i] != min) {
                secondMin = arr[i];
            }
        }
        return secondMin;
    }
}
