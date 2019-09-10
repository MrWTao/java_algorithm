package leetcode.easy;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbStairs {
    public static void main(String[] args) {
        int i = new ClimbStairs().climbStairs(6);
        System.out.println(i);
    }

    private int climbStairs(int n) {
        int[] stairs = new int[n + 1];
        stairs[0] = 0;
        if(n == 0){
            return 0;
        }
        stairs[1] = 1;
        if(n == 1){
            return 1;
        }
        stairs[2] = 2;
        for (int i = 3; i <= n; i++) {
            stairs[i] = stairs[i - 1] + stairs[i - 2];
        }
        return stairs[n];
    }
}
