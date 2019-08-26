package leetcode.middle;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

/**
 * 有N个网络节点,标记为1到N;
 * 给定一个列表times,表示信号经过有向边的传递时间.times[i]=(u,v,w),
 * 其中u是源节点,v是目标节点,w是一个信号从源节点传递到目标节点的时间.
 * 现在我们向当前的节点K发送了一个信号.需要多久才能使所有节点都收到信号?
 * 如果不能使所有节点收到信号返回-1.
 */
public class NetworkDelayTime {
    public static void main(String[] args) {


    }

    public int networkDelayTime(int[][] times, int N, int K) {
        // 构造邻接矩阵
        int[][] graphic = new int[N+1][N+1];
        for (int i = 0; i < times.length; i++) {
            graphic[times[i][0]][times[i][1]] = times[i][2];
        }
        // 使用单源最短路径算法
        int[] result = new int[graphic.length];
        // 存放的是[节点,start到节点的距离]
        HashMap<Integer,Integer> unFind = new HashMap<>();
        for (int i = 1; i < graphic.length; i++) {
            if (graphic[K][i] == 0) {
                unFind.put(i, Integer.MAX_VALUE);
            } else {
                unFind.put(i, graphic[K][i]);
            }
        }
        // 取出最短路径
        while (unFind.size() > 0) {
            int minPath = Integer.MAX_VALUE;
            int minIndex = Integer.MAX_VALUE;
            Set<Integer> keySet = unFind.keySet();
            for (Integer key : keySet
            ) {
                if(minPath > unFind.get(key)){
                    minPath = unFind.get(key);
                    minIndex = key;
                }
            }
            result[minIndex] = unFind.get(minIndex);
            unFind.remove(minIndex);
            keySet.remove(minIndex);
            // 判断其他的距离是否需要变更
            for (Integer key : keySet
            ) {
                if(graphic[minIndex][key] != 0 && result[minIndex] + graphic[minIndex][key] < unFind.get(key)){
                    unFind.replace(key, result[minIndex] + graphic[minIndex][key]);
                }
            }
        }
        result[K] = 0;
        int maxValue = 0;
        int count = 0;
        for (int i = 1; i < result.length; i++) {
            if(result[i]!=0){
                count++;
            }
            if(result[i]>maxValue){
                maxValue = result[i];
            }
        }
        if(count<N){
            return -1;
        }
        return maxValue;
    }
}