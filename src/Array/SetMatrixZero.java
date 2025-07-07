//package Array;
//
//public class SetMatrixZero {
//    public static void main(String[] args) {
//        int[][] matrix = {{1, 1, 1, 1}, {1, 0, 1, 1}, {1, 0, 0, 1}, {1, 1, 1, 1}};
//        int n = matrix.length;
//        int m = matrix[0].length;
//        setZeros(matrix, n, m);
//
//        // Print the modified matrix
//        for (int[] row : matrix) {
//            for (int element : row) {
//                System.out.print(element + " ");
//            }
//            System.out.println();
//        }
//    }
//
//    private static void setZeros(int[][] matrix, int n, int m) {
//        // Variables to track if first row and first column need to be zeroed
//        boolean firstRowHasZero = false;
//        boolean firstColHasZero = false;
//
//        // Check if first row has any zero
//        for (int j = 0; j < m; j++) {
//            if (matrix[0][j] == 0) {
//                firstRowHasZero = true;
//                break;
//            }
//        }
//
//        // Check if first column has any zero
//        for (int i = 0; i < n; i++) {
//            if (matrix[i][0] == 0) {
//                firstColHasZero = true;
//                break;
//            }
//        }
//
//        // Use first row and column as markers
//        // Scan the rest of the matrix (excluding first row and column)
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < m; j++) {
//                if (matrix[i][j] == 0) {
//                    matrix[i][0] = 0; // Mark first cell of row
//                    matrix[0][j] = 0; // Mark first cell of column
//                }
//            }
//        }
//
//        // Set rows to zero based on markers in first column
//        for (int i = 1; i < n; i++) {
//            if (matrix[i][0] == 0) {
//                for (int j = 1; j < m; j++) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//
//        // Set columns to zero based on markers in first row
//        for (int j = 1; j < m; j++) {
//            if (matrix[0][j] == 0) {
//                for (int i = 1; i < n; i++) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//
//        // Set first row to zero if needed
//        if (firstRowHasZero) {
//            for (int j = 0; j < m; j++) {
//                matrix[0][j] = 0;
//            }
//        }
//
//        // Set first column to zero if needed
//        if (firstColHasZero) {
//            for (int i = 0; i < n; i++) {
//                matrix[i][0] = 0;
//            }
//        }
//    }
//}



package Array;

public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1, 1}, {1, 0, 1, 1}, {1, 0, 0, 1}, {1, 1, 1, 1}};
        int n = matrix.length;
        int m = matrix[0].length;
        setZeros(matrix, n, m);

        // Print the modified matrix
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static void setZeros(int[][] matrix, int n, int m) {
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[m];

        // Step 1: Mark rows and columns that contain zeros
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Step 2: Set zeros in marked rows and columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}