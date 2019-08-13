package leetcode.middle;

/**
 * 我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。
 * 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"].
 * 我们可以按下面的指令规则行动：
 * 如果方格存在，'U' 意味着将我们的位置上移一行；
 * 如果方格存在，'D' 意味着将我们的位置下移一行；
 * 如果方格存在，'L' 意味着将我们的位置左移一列；
 * 如果方格存在，'R' 意味着将我们的位置右移一列；
 * '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。
 * 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。
 * 输入：target = "leet"
 * 输出："DDR!UURRR!!DDD!"
 */
public class AlphabetBoardPath {
    public static void main(String[] args) {
        String target = "zookeeper";
        String res = new AlphabetBoardPath().alphabetBoardPath(target);
        System.out.println(res);
    }

    private String alphabetBoardPath(String target) {
        if (target == null || target.equals("")) {
            return "";
        }
        // 获取每个位置的坐标
        int[][] position = new int[target.length()][2];
        for (int i = 0; i < target.length(); i++) {
            position[i] = getXY(target.charAt(i));
        }
        StringBuilder result = new StringBuilder();
        result.append(move(0, 0, position[0][0], position[0][1]));
        for (int i = 0; i < position.length - 1; i++) {
            result.append(move(position[i][0], position[i][1], position[i + 1][0], position[i + 1][1]));
        }
        return result.toString();
    }


    private String move(int startX, int startY, int endX, int endY) {
        if (startX == endX && startY == endY) {
            return "!";
        }
        StringBuilder sb = new StringBuilder();
        if (startX == 5) {// 从z出发
            for (int i = 0; i < startX - endX; i++) {
                sb.append("U");
            }
            for (int i = 0; i < endY - startY; i++) {
                sb.append("R");
            }
        } else if (endX == 5) {// 到达z
            for (int i = 0; i < startY - endY; i++) {
                sb.append("L");
            }
            for (int i = 0; i < endX - startX; i++) {
                sb.append("D");
            }
        } else {// 其他情况
            if (startX >= endX) {
                for (int i = 0; i < startX - endX; i++) {
                    sb.append("U");
                }
            } else {
                for (int i = 0; i < endX - startX; i++) {
                    sb.append("D");
                }
            }
            if (startY >= endY) {
                for (int i = 0; i < startY - endY; i++) {
                    sb.append("L");
                }
            } else {
                for (int i = 0; i < endY - startY; i++) {
                    sb.append("R");
                }
            }
        }
        sb.append("!");
        return sb.toString();
    }

    private int[] getXY(char ch) {
        if (ch >= 'a' && ch <= 'e') {
            return new int[]{0, ch - 'a'};
        }
        if (ch >= 'f' && ch <= 'j') {
            return new int[]{1, ch - 'f'};
        }
        if (ch >= 'k' && ch <= 'o') {
            return new int[]{2, ch - 'k'};
        }
        if (ch >= 'p' && ch <= 't') {
            return new int[]{3, ch - 'p'};
        }
        if (ch >= 'u' && ch <= 'y') {
            return new int[]{4, ch - 'u'};
        }
        return new int[]{5, 0};
    }
}
