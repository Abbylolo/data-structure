package easy;

/**
 * 704.二分查找（简单）
 * @author Abby
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int head = 0;
        int tail = nums.length - 1;
        int middle = 0;
        while(head <= tail) {
            middle = head + (tail - head) / 2;
            if(target == nums[middle]) {
                return middle;
            } else if(target > nums[middle]) {
                head = middle + 1;
            } else {
                tail = middle - 1;
            }
        }
        return -1;
    }
}

class BinarySearchTest {
    public static void main(String[] args) {
        int[] nums = {1,2,3,6,8,11};
        int target = 2;
        int result = new BinarySearch().search(nums,target);
        System.out.println(result);
    }
}
