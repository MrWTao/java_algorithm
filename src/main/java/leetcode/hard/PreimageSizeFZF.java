package leetcode.hard;

/**
 * f(x) 是 x! 末尾是0的数量。（回想一下 x! = 1 * 2 * 3 * ... * x，且0! = 1）
 * 例如， f(3) = 0 ，因为3! = 6的末尾没有0；而 f(11) = 2 ，因为11!= 39916800末端有2个0。给定 K，找出多少个非负整数x ，有 f(x) = K 的性质。
 */
public class PreimageSizeFZF {
    public static void main(String[] args) {
        int i = new PreimageSizeFZF().preimageSizeFZF(5);
        System.out.println(i);
    }

    /**
     * 如果f(n)末尾有0，那么n一定是大于5的数，因为只有包含5的因子配上之前的2才能构成一个末尾的0；
     * 所以说给定K只需要只要K前面的所有整数中可以分解出多少个5即可；
     * @param K f(n) = K
     * @return 满足f(n) = K 的n的个数
     */
    public int preimageSizeFZF(int K) {
        //确定阶梯值范围 最终的到的K < start
        int start = 1;
        while (start < K){
            start = start*5+1;
        }
        //确定范围后，执行精确查找
        while (start > 1){
            //只有5以下阶乘才会出现start-1成立，其它情况不会存在，因为任何一个阶段分界值都会包含一个以上的5
            if(start-1 == K){
                //不存在的返回0
                return 0;
            }
            //逆推下一个阶梯值 从f(x+1) 推导出f(x)
            start=(start-1)/5;

            //获取剩余值，进行下一阶梯运算
            K%=start;
        }
        //只要存在，必然是5个
        return 5;
    }
}
