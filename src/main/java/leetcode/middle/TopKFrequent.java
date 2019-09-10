package leetcode.middle;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        System.out.println(new TopKFrequent().topKFrequent(words, k));
    }

    private List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> queue = new PriorityQueue<>(k, (o1, o2) -> {
            if (map.get(o1).equals(map.get(o2))) {
                return o2.compareTo(o1);
            }
            return map.get(o1).compareTo(map.get(o2));
        });
        for (String key : map.keySet()) {
            if (queue.size() < k) {
                queue.offer(key);
            } else if (queue.comparator().compare(key, queue.peek()) > 0) {
                queue.poll();
                queue.offer(key);
            }
        }
        String[] result = new String[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = queue.poll();
        }
        return Arrays.asList(result);
    }
}
