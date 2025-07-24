package stack;

import java.util.Stack;

public class NextLargestNearestElement {
    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 4};
        int n = arr.length;
        int[] nextLarger = nextLargerElement(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.print(nextLarger[i] + " ");
        }
    }

    private static int[] nextLargerElement(int[] arr, int n) {
        int[] nextLarger = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nextLarger[i] = -1;
            } else {
                nextLarger[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return nextLarger;
    }
}
