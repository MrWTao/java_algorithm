package sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19, 0};
        new BubbleSort().bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 冒泡排序
     */
    private void bubbleSort(int[] nums) {
        boolean flag;// 标志此轮循环是否有交换发生
        int temp;
        for (int i = 0; i < nums.length; i++) {
            flag = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = true;
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            }
        }


    }
}
