package leetcode.middle;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class ArrayRemove {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int i = new ArrayRemove().removeDuplicates(nums);
        System.out.println(i);
    }

    private int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int currentValue = nums[0];// 记录当前位置前一个的值
        int count = 1;// 记录currentValue出现的次数
        int slowCursor = 1;// 慢指针代表当前有效的位置
        int fastCursor = 1;// 快指针需要遍历所有
        while (fastCursor < nums.length) {
            if (nums[fastCursor] != currentValue) {// 没有重复
                currentValue = nums[fastCursor];
                count = 1;
                nums[slowCursor] = nums[fastCursor];
                fastCursor++;
                slowCursor++;
            } else {// 重复出现
                if(count == 2){
                    while ( nums[fastCursor] == currentValue) {
                        fastCursor++;
                        if(fastCursor == nums.length){
                            return slowCursor;
                        }
                    }
                    currentValue = nums[fastCursor];
                    count = 1;
                    nums[slowCursor] = nums[fastCursor];
                    fastCursor++;
                    slowCursor++;
                }else {
                    nums[slowCursor] = currentValue;
                    count ++;
                    slowCursor ++;
                    fastCursor ++;
                }
            }
        }
        return slowCursor;
    }
}
