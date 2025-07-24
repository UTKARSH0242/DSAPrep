package stack;

import java.util.Stack;

public class PreviousSmallestNearestElement {
    public static void main(String[] args) {
        int arr[] = {1, 3, 2, 4};
        int n = arr.length;
        int [] prevSmaller = previousSmallerElement(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.print(prevSmaller[i] + " ");
        }
    }

    private static int[] previousSmallerElement(int[] arr, int n) {
        int[] prevSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                prevSmaller[i] = -1;
            } else {
                prevSmaller[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return prevSmaller;
    }
}
