package nowcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StrAllPai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        String init = sc.nextLine();
        String s;
        int[][] nums = new int[init.length()][init.length()];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < init.length(); i++) {
            nums[i][i] = 1;
            map.put(init.charAt(i), i);
        }
        while (n > 1) {
            s = sc.nextLine();
            n--;
            for (int i = 0; i < s.length(); i++) {
                nums[i][map.get(s.charAt(i))]++;
            }
        }
        int count;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            count = nums[i][0];
            for (int j = 1; j < nums[0].length; j++) {
                if (nums[i][j] > count) {
                    stringBuilder.append(init.charAt(j - 1));
                    break;
                } else if (nums[i][j] < count) {
                    stringBuilder.append(init.charAt(j));
                    break;
                }
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
