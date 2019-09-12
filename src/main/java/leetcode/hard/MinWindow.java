package leetcode.hard;

public class MinWindow {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new MinWindow().minWindow(s, t));
    }

    private String minWindow(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] pChars = t.toCharArray();
        int[] pMap = new int[128];
        int i = 0, j = 0; // 考察窗口[i,j-1]
        int count = pChars.length;
        int minLen = s.length() + 1,l = 0,r = 0;
        for (char pChar : pChars)
            pMap[pChar]++;
        while (j < sChars.length) {
            //减小计数
            if (pMap[sChars[j]] > 0)
                count--;
            pMap[sChars[j]]--;
            j++;
            //计数为 0说明区间[i,j-1] 包含 p
            while (count == 0) {
                //求得一个解
                if (j - i < minLen) {
                    minLen = j - i;
                    l = i;
                    r = j;
                }
                pMap[sChars[i]]++;
                // 增加计数
                if (pMap[sChars[i]] > 0)
                    count++;
                i++;
            }
        }
        return minLen == s.length() + 1 ? "" : s.substring(l, r);
    }
}
