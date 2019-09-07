package leetcode.middle;

/**
 * 在mXn的方格中，从左上角到右下角一共有多少条路径
 */
public class PathCount {
    public static void main(String[] args) {
        int i = new PathCount().uniquePaths(7, 3);
        System.out.println(i);
    }

    private int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];
    }
}
