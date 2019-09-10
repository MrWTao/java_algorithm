package leetcode.middle;

import java.util.*;

/**
 * 对于一个具有树特征的无向图，我们可选择任何一个节点作为根。图因此可以成为树，在所有可能的树中，
 * 具有最小高度的树被称为最小高度树。给出这样的一个图，写出一个函数找到所有的最小高度树并返回他们的根节点。
 */
public class FindMinHeightTrees {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}};
        List<Integer> minHeightTrees = new FindMinHeightTrees().findMinHeightTrees(n, edges);
        System.out.println(minHeightTrees);
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        boolean[][] relation = new boolean[n][n];//两点之间是否有关系
        boolean[] isThrow = new boolean[n];//这个点是否被抛弃
        int[] numOfLink = new int[n];//这个点的连接数（1个就是叶子）
        int mark = n;//标记还剩多少个，<2就可以停止了
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            relation[x][y] = true;
            relation[y][x] = true;
            numOfLink[x]++;
            numOfLink[y]++;
        }
        while (mark > 2) {
            //找到叶子
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!isThrow[i] && numOfLink[i] == 1) {
                    arr.add(i);
                }
            }
            //删除叶子
            for (int k = 0; k < arr.size(); k++) {
                int i = arr.get(k);
                isThrow[i] = true;
                mark--;
                for (int j = 0; j < n; j++) {
                    if (relation[i][j]) {
                        numOfLink[j]--;
                    }
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!isThrow[i]) {
                list.add(i);
            }
        }
        return list;
    }
}
