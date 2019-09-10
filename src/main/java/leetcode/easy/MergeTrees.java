package leetcode.easy;

/**
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为
 * 节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 */
public class MergeTrees {
    public static void main(String[] args) {
        // 构造测试用例二叉树
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(5);
        TreeNode treeNode = new MergeTrees().mergeTrees(root, root);
        TreeReverse.printTree(treeNode);
    }
    private TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 != null) {
            return t2;
        }
        if (t2 == null && t1 != null) {
            return t1;
        }
        if (t2 == null && t1 == null) {
            return null;
        }
        TreeNode node = new TreeNode(t1.value+t2.value);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);
        return node;
    }
}
