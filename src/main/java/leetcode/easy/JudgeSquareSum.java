package leetcode.easy;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 */
public class JudgeSquareSum {
    public static void main(String[] args) {
        boolean b = new JudgeSquareSum().judgeSquareSum(8);
        System.out.println(b);
    }

    private boolean judgeSquareSum(int c) {
        int n = (int) Math.floor(Math.sqrt(c));
        int i = 0;
        int j = n;
        while (i<=j) {
            if(i*i+j*j<c){
                i++;
            }else if(i*i+j*j==c){
                return true;
            }else {
                j--;
            }
        }
        return false;
    }
}
