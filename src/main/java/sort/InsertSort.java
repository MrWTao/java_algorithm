package sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19, 0};
        new InsertSort().insertSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private void insertSort(int[] nums) {
        // 插入排序的思想：将无序的序列一次插入到有序的序列中
        int hasSort = 0;
        int temp;
        for (int i = hasSort + 1; i < nums.length; i++) {
            temp = nums[i];
            int j = hasSort;
            while (j >= 0 && nums[j] > temp) {
                nums[j+1] = nums[j];
                j -- ;
            }
            nums[j+1] = temp;
            hasSort++;
        }
    }
}
