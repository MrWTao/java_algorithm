package leetcode.middle;

import java.util.Arrays;

/**
 * 给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
 * 返回 A 的任意排列，使其相对于 B 的优势最大化。
 * 输入：A = [12,24,8,32], B = [13,25,32,11]
 * 输出：[24,32,8,12]
 */
public class AdvantageCount {
    public static void main(String[] args) {
        int[] a = {12,24,8,32};
        int[] b = {13,25,32,11};
        int[] ints = new AdvantageCount().advantageCount(a, b);
        System.out.println(Arrays.toString(ints));
    }

    private int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        boolean[] flag = new boolean[A.length];
        int[] res = new int[A.length];
        boolean get;// 表示是否能找到应对B[i]的A[j]
        for (int i = 0; i < res.length; i++) {
            get = false;
            for (int j = 0; j < A.length; j++) {
                if (A[j] > B[i] && !flag[j]) {
                    res[i] = A[j];
                    flag[j] = true;
                    get = true;
                    break;
                }
            }
            if (!get) {
                for (int j = 0; j < A.length; j++) {
                    if (!flag[j]) {
                        res[i] = A[j];
                        flag[j] = true;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
