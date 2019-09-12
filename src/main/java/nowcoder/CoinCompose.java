package nowcoder;

import java.util.Scanner;

/**
 * 有1分，2分，5分，10分四种硬币，每种硬币数量无限，给定n分钱(n <= 100000)，有多少中组合可以组成n分钱？
 */
public class CoinCompose {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = {1,2,5,10};
        long[] dp = new long[n+1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++){
            for(int j=coins[i];j<=n;j++){
                dp[j]+=dp[j-coins[i]];
            }
        }
        System.out.println(dp[n]%(long)(Math.pow(10,9)+7));
    }
}
