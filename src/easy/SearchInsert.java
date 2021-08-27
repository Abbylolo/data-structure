package easy;

/**
 * 35.搜索插入位置
 * 二分查找
 * @author Abby
 */
public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1, middle = 0;
        while(low <= high) {
            middle = low + (high - low ) / 2;
            if(nums[middle] == target) {
                return middle;
            } else if(nums[middle] > target) {
                high = middle -1;
            } else {
                low = middle +1;
            }
        }
        // 也可以return left
        return (nums[middle] < target)?middle + 1:middle;
    }
}

class SearchInsertTest {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 9;
        int result = new SearchInsert().searchInsert(nums,target);
        System.out.print(result);
    }
}