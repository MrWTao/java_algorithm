package leetcode.middle;

import java.util.LinkedList;

/**
 * 给定一个二叉树，在树的最后一行找到最左边的值。
 * 输入:
 * 1
 * / \
 * 2   3
 * /   / \
 * 4   5   6
 * /
 * 7
 * 输出:
 * 7
 */
public class FindBottomLeftValue {

    public static void main(String[] args) {

    }

    // 使用两个队列，分层广度优先搜索
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> queue1 = new LinkedList<>();
        LinkedList<TreeNode> queue2 = new LinkedList<>();
        TreeNode current;
        TreeNode result = null;
        queue1.addLast(root);
        while (true) {
            if (queue1.size() > 0) {
                result = queue1.getFirst();
            }else {
                return result.val;
            }
            while ((current = queue1.pollFirst()) != null) {
                if (current.left != null) {
                    queue2.addLast(current.left);
                }
                if (current.right != null) {
                    queue2.addLast(current.right);
                }
            }
            if (queue2.size() > 0) {
                result = queue2.getFirst();
            }else {
                return result.val;
            }
            while ((current = queue2.pollFirst()) != null) {
                if (current.left != null) {
                    queue1.addLast(current.left);
                }
                if (current.right != null) {
                    queue1.addLast(current.right);
                }
            }
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
