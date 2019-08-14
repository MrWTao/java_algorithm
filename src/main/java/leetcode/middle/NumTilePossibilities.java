package leetcode.middle;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 * 输入："AAB"
 * 输出：8
 * 解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
 */
public class NumTilePossibilities {
    public static void main(String[] args) {
        String tiles = "AAABBC";
        int i = new NumTilePossibilities().numTilePossibilities(tiles);
        System.out.println(i);
    }

    // 统计每个字母出现的次数，然后就是构造排列树，算出排列树的节点数目即可
    private int numTilePossibilities(String tiles) {
        int[] nums = new int[8]; // 前七位存放不同字母的出现的次数，最后一位存放排列树的节点数
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tiles.length(); i++) {
            map.put(tiles.charAt(i), map.get(tiles.charAt(i)) == null ? 1 : map.get(tiles.charAt(i)) + 1);
        }
        Set<Character> characters = map.keySet();
        int index = 0;
        for (Character ch : characters) {
            if (map.get(ch) >= 1) {
                nums[index++] = map.get(ch);
            }
        }
        recursion(nums);
        return nums[7];
    }

    private void recursion(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > 0) {
                nums[7]++;
                nums[i]--;
                recursion(nums);
                nums[i]++;// 回溯之后走下一个字母
            }
        }
    }
}
