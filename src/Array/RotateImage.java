package array;

public class RotateImage {
    public static void main(String[] args) {
        int arr [][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Original Matrix");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Rotated Matrix");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println("Rotate matrix by 90 degrees");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[arr.length - 1 - j][i] + " ");
            }
            System.out.println();
        }
    }
}
