package leetcode.easy;

/**
 * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
 * 输入: [4,2,1]
 * 输出: False
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 */
public class CheckPossibility {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,5,6,8,77};
        boolean b = new CheckPossibility().checkPossibility(nums);
        System.out.println(b);
    }

    private boolean checkPossibility(int[] nums) {
        if(nums.length<=2){
            return true;
        }
        int count = 0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                if(count==1){
                    return false;
                }else{
                    count ++;
                    if(i>0&&i<nums.length-2){
                        if((nums[i]>=nums[i-1]&&nums[i]<=nums[i+2])||(nums[i+1]>=nums[i-1]&&nums[i+1]<=nums[i+2])){
                        }else{
                            return false;
                        }
                    }
                    if(i==0&&nums[2]<nums[0]&&nums[1]>nums[2]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
