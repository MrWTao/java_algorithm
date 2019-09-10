package leetcode.easy;

/**
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 你找到的子数组应是最短的，请输出它的长度。
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 */
public class FindUnsortedSubarray {

    public static void main(String[] args) {
        int[] ints = {2, 6, 4, 8, 10, 9, 15};
        int unsortedSubarray = new FindUnsortedSubarray().findUnsortedSubarray(ints);
        System.out.println(unsortedSubarray);
    }

    private int findUnsortedSubarray(int[] nums) {
        int leftMax = nums[0];
        int rightMin = nums[nums.length - 1];
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < leftMax) {
                left = i;
            } else {
                leftMax = Math.max(leftMax, nums[i]);
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > rightMin) {
                right = i;
            } else {
                rightMin = Math.min(rightMin, nums[i]);
            }
        }
        return ((left - right + 1)>1)?(left - right + 1):0;
    }
}
