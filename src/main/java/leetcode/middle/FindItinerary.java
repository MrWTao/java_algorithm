package leetcode.middle;

import java.util.*;

/**
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。
 * 所有这些机票都属于一个从JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 出发。
 * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 */
public class FindItinerary {
//[["EZE","AXA"],["TIA","ANU"],["ANU","JFK"],["JFK","ANU"],["ANU","EZE"],["TIA","ANU"],["AXA","TIA"],["TIA","JFK"],["ANU","TIA"],["JFK","TIA"]]
    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        tickets.add(Arrays.asList("EZE","AXA"));
        tickets.add(Arrays.asList("TIA","ANU"));
        tickets.add(Arrays.asList("ANU","JFK"));
        tickets.add(Arrays.asList("JFK","ANU"));
        tickets.add(Arrays.asList("ANU","EZE"));
        tickets.add(Arrays.asList("TIA","ANU"));
        tickets.add(Arrays.asList("AXA","TIA"));
        tickets.add(Arrays.asList("TIA","JFK"));
        tickets.add(Arrays.asList("ANU","TIA"));
        tickets.add(Arrays.asList("JFK","TIA"));
        List<String> list = new FindItinerary().findItinerary(tickets);
        System.out.println(list);
    }

    private List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, TreeSet<String>> map = new HashMap<>();
        TreeSet<String> set;
        for (List<String> list : tickets) {
            if (map.get(list.get(0)) == null) {
                // 这个位置放置有出现相同的字符数组，本身TreeSet不能存放相同元素
                set = new TreeSet<>((o1, o2) -> {
                    int i = o1.compareTo(o2);
                    return i==0?1:i;
                });
            } else {
                set = map.get(list.get(0));
            }
            set.add(list.get(1));
            map.put(list.get(0), set);
        }
        LinkedList<String> result = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        // 每一次走到头没有路可走将其返回作为此时的终点
        while (!stack.empty()) {
            while (map.get(stack.peek()) != null && map.get(stack.peek()).size() > 0) {
                stack.push(map.get(stack.peek()).pollFirst());
            }
            result.addFirst(stack.pop());
        }
        return result;
    }
}
