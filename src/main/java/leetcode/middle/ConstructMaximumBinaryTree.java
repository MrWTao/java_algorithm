package leetcode.middle;

/**
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * 1.二叉树的根是数组中的最大元素。
 * 2.左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 3.右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *    6
 *  /   \
 * 3     5
 *  \    /
 *   2  0
 *    \
 *     1
 */
public class ConstructMaximumBinaryTree {
    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        ConstructMaximumBinaryTree tree = new ConstructMaximumBinaryTree();
        TreeNode treeNode = tree.constructMaximumBinaryTree(nums);
        tree.printTree(treeNode);
    }

    private TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructNode(nums,0,nums.length-1);
    }

    private void printTree(TreeNode root){
        if(root!=null){
            System.out.print(root.val+" ");
            printTree(root.left);
            printTree(root.right);
        }
    }

    private TreeNode constructNode(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int index = start;
        for (int i = start; i <= end; i++) {
            if(nums[i]>nums[index]){
                index = i;
            }
        }
        TreeNode node = new TreeNode(nums[index]);
        node.left = constructNode(nums,start,index-1);
        node.right = constructNode(nums,index+1,end);
        return node;
    }
}
