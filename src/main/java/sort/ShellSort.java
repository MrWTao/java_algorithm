package sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] nums={10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19, 0};
        new ShellSort().shellSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 增量排序：分组进行简单插入排序
     */
    private void shellSort(int[] nums) {
        int gap = nums.length / 2;
        int temp;
        while (gap > 0) {
            for (int i = gap; i < nums.length; i++) {
                int index = i;
                temp = nums[i];
                while (index - gap >= 0 && nums[index - gap] > temp) {
                    nums[index] = nums[index - gap];
                    index -= gap;
                }
                nums[index] = temp;
            }
            gap /= 2;
        }
    }
}
