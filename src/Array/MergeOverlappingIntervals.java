package array;

import java.util.Arrays;
import java.util.Comparator;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {7, 9},{9,11},{8,10},{2,4},{15, 18},{16,17}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int n = intervals.length;
        int[][] merged = new int[n][2];
        int mergedSize = 0;

        for (int i = 0; i < n; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];

            if (mergedSize == 0 || merged[mergedSize - 1][1] < left) {
                merged[mergedSize++] = intervals[i];
            } else {
                merged[mergedSize - 1][1] = Math.max(merged[mergedSize - 1][1], right);
            }
        }

        return Arrays.copyOf(merged, mergedSize);

    }
}
