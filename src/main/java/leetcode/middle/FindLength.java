package leetcode.middle;

/**
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * 输入:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出:
 * 3
 * 解释:
 * 长度最长的公共子数组是 [3, 2, 1]。
 */
public class FindLength {

    public static void main(String[] args) {
        int[] A = new int[]{1,2,3,2,1};
        int[] B = new int[]{3,2,1,4,7};
        int length = new FindLength().findLength(A,B);
        System.out.println(length);
    }

    private int findLength(int[] A, int[] B) {
        int a = A.length;
        int b = B.length;
        // dp[i][j]表示以A[i]和B[j]结尾的数组的最长子数组的长度
        int[][] dp = new int[a][b];
        for (int i = 0; i < a; i++) {
            dp[i][0] = A[i] == B[0] ? 1 : 0;
        }
        for (int i = 0; i < a; i++) {
            dp[0][i] = A[0] == B[i] ? 1 : 0;
        }
        int maxLength = 0;
        for (int i = 1; i < a; i++) {
            for (int j = 1; j < b; j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return maxLength;
    }
}
