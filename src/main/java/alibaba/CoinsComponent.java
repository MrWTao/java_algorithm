package alibaba;

import java.util.Arrays;

/**
 * 1. 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * 例 1:  coins = [1, 2, 5], amount = 12, result =3 (5 + 5 + 2 = 12)
 * 例 2:  coins = [2], amount = 3, result = -1
 * 说明:每种硬币的数量是无限的。
 */
public class CoinsComponent {
    public static void main(String[] args) {
        int[] coins = {2};
        int amount = 3;
        int result = minCoinNum(coins, amount);
        System.out.println(result);
    }

    /**
     * @param coins  可用的硬币面值
     * @param amount 总金额
     * @return 最小的硬币数量
     */
    private static int minCoinNum(int[] coins, int amount) {
        if(coins.length==0||amount<=0){
            return -1;
        }
        // 使用动态规划，从0开始求直到amount数量最小硬币的数量
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            // 查看每种硬度的加入是否可以减小需要的数量
            for (int coin : coins) {
                // 加入该面值后可以使得当前的最小数量变小
                if(i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[i - coin] + 1);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}
