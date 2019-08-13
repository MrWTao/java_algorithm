package leetcode.middle;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapListPairs {
    public static void main(String[] args) {
        // 构造链表
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(head);
        ListNode listNode = new SwapListPairs().swapPairs(head);
        System.out.println(listNode);
    }

    private ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while(cur != null){
            sb.append(cur.val).append(" ");
            cur = cur.next;
        }
        return sb.toString();
    }
}
