package leetcode.middle;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 1.你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 2.卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] prices = {1,2,3,0,2};
        int i = new MaxProfit().maxProfit(prices);
        System.out.println(i);
    }
    private int maxProfit(int[] prices) {
        if(prices == null || prices.length==0){
            return 0;
        }
        int len = prices.length;
        // 第i天买入的最大利润
        int[] buy = new int[len];
        // 第i天卖出的最大利润
        int[] sell = new int[len];
        // 第i天冷却的最大利润
        int[] coolDown = new int[len];
        buy[0] = -prices[0];
        sell[0] = 0;
        coolDown[0] = 0;
        for (int i = 1; i < len; i++) {
            buy[i] = Math.max(buy[i - 1], coolDown[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            coolDown[i] = Math.max(coolDown[i-1],Math.max(buy[i - 1],sell[i - 1]));
        }
        return sell[len-1];
    }
}
