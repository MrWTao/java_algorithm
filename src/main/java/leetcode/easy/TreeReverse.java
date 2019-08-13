package leetcode.easy;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 2. 翻转一棵二叉树
 * 例：
 *     3
 *   /   \
 *  2     8
 * / \   / \
 *1   4 5   9
 *     3
 *   /   \
 *  8     2
 * / \   / \
 *9   5 4   1
 */
public class TreeReverse {
    public static void main(String[] args) {
        // 构造测试用例二叉树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(5);
        // 输出构造的二叉树
        System.out.println("翻转前：");
        printTree(root);
        reverseTree(root);
        // 输出翻转后的二叉树
        System.out.println("翻转后：");
        printTree(root);
    }

    // 层序遍历输出，方便检验结果
    private static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeNode first = queue.poll();
            if (first != null) {
                System.out.print(first.value + " ");
                if (first.left != null) {
                    queue.add(first.left);
                }
                if (first.right != null) {
                    queue.add(first.right);
                }
            }
        }
        System.out.println();
    }

    private static void reverseTree(TreeNode root) {
        // 当前节点不为null
        if (root != null) {
            TreeNode tempNode = root.left;
            root.left = root.right;
            root.right = tempNode;
            reverseTree(root.left);
            reverseTree(root.right);
        }
    }
}

/**
 * 二叉树节点类
 */
class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}