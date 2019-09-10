package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
 * 也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 */
public class IsHappy {
    public static void main(String[] args) {
        boolean happy = new IsHappy().isHappy(19);
        System.out.println(happy);
    }

    private boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int sumOfNum;
        while (true) {
            sumOfNum = getSumOfNum(n);
            if (map.get(sumOfNum) != null) {
                return false;
            } else {
                if (sumOfNum == 1) {
                    return true;
                }
                map.put(sumOfNum, 1);
            }
            n = sumOfNum;
        }
    }

    private int getSumOfNum(int m) {
        int squaresum=0;
        while(m!=0){
            squaresum+=(m%10)*(m%10);
            m/=10;
        }
        return squaresum;
    }
}
