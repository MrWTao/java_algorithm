package leetcode.easy;

public class FindInMatrix {
    public static void main(String[] args) {


    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // 横向查找索引位置
        int x = findIndex(matrix[0], 0, matrix[0].length - 1, target);
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[x][i] == target) {
                return true;
            }
        }
        return false;
    }

    public int findIndex(int[] a, int start, int end, int target) {
        if (end - start == 1) {
            return start;
        }
        while (end > start + 1) {
            int mid = (end + start) / 2;
            if (a[mid] > target) {
                end = mid;
            } else if (a[mid] < target) {
                start = mid;
            } else {
                return mid;
            }
        }
        return Math.min(start, end);
    }
}
