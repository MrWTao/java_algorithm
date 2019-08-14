package leetcode.middle;

/**
 * 给定两个整数 A 和 B，返回任意字符串 S，要求满足：
 * S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母；
 * 子串 'aaa' 没有出现在 S 中；
 * 子串 'bbb' 没有出现在 S 中。
 * 输入：A = 1, B = 2
 * 输出："abb"
 * 解释："abb", "bab" 和 "bba" 都是正确答案。
 */
public class StrWithoutAB {

    public static void main(String[] args) {
        String s = new StrWithoutAB().strWithout3a3b(5, 4);
        System.out.println(s);
    }

    /**
     * 满足这个题目假设的A、B一定满足关系0<=A-B<=B+2(假设A>B的情况，反之就是0<=B-A<=A+2)
     * 只需要先abababab按照AB中小的数字走一遍，然后把大的一方剩余的部分塞进去即可
     */
    private String strWithout3a3b(int A, int B) {
        String doubleStr = "aab", singleStr = "ab";
        if (A < B) {
            int temp = A;
            A = B;
            B = temp;
            doubleStr = "bba";
            singleStr = "ba";
        }
        StringBuilder sb = new StringBuilder();
        if (A - B <= B) {// A比B大，但是不足以2:1
            for (int i = 0; i < A - B; i++) {
                sb.append(doubleStr);
            }
            for (int i = 0; i < 2 * B - A; i++) {
                sb.append(singleStr);
            }
        }else if (A - 2 * B == 1) {// A比B大，以2:1分配后还多一个
            for (int i = 0; i < B; i++) {
                sb.append(doubleStr);
            }
            sb.append(singleStr.equals("ab") ? "a" : "b");
        } else if (A - 2 * B == 2) {// A比B大，以2:1分配后还多两个
            for (int i = 0; i < B; i++) {
                sb.append(doubleStr);
            }
            sb.append(singleStr.equals("ab") ? "aa" : "bb");
        }
        return sb.toString();
    }
}
