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

    /**
     * 递归实现二分查找
     */
    public int search2(int low,int high,int[] nums,int target) {
        int mid = low + (high - low) / 2;
        if(low <= high) {
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                return search2(low,mid - 1,nums,target);
            } else {
                return search2(mid + 1,high,nums,target);
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
        int result2 = new BinarySearch().search2(0,nums.length - 1,nums,11);
        System.out.println("普通二分："+result+"\n递归二分："+result2);
    }
}
