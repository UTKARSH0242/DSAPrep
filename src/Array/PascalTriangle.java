package Array;//package Array;
//
//public class PascalTriangle {
//    public static void main(String[] args) {
//        int n = 6;
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j <= i; j++) {
//                System.out.print(factorial(i) / (factorial(j) * factorial(i - j)) + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    private static int factorial(int i) {
//        int fact = 1;
//        for (int j = 1; j <= i; j++) {
//            fact *= j;
//        }
//        return fact;
//    }
//}




import java.util.*;

public class PascalTriangle {
    public static int nCr(int n, int r) {
        long res = 1;
        // calculating nCr:
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return (int) res;
    }

    public static List<List<Integer>> pascalTriangle(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        // Store the entire Pascal's triangle:
        for (int row = 1; row <= n; row++) {
            List<Integer> tempLst = new ArrayList<>(); // temporary list
            for (int col = 1; col <= row; col++) {
                tempLst.add(nCr(row - 1, col - 1));
            }
            ans.add(tempLst);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> ans = pascalTriangle(n);
        for (List<Integer> it : ans) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
