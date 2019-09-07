package leetcode.easy;

/**
 * 找出n!中末尾0的个数
 */
public class TrailingZeros {
    public static void main(String[] args) {
        int i = new TrailingZeros().trailingZeroes(30);
        System.out.println(i);
    }

    private int trailingZeroes(int n) {
        int res = 0;
        while (n >= 5) {
            res += n/5;
            n = n/5;
        }
        return res;
    }
}
