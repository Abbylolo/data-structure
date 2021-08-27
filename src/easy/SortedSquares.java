package easy;

/**
 * 977.有序数组的平方
 * 双指针
 * @author Abby
 */

import java.util.Arrays;

public class SortedSquares {

    /**
     * 法一 —— 平方后直接排序
     * @author Abby
     */
    public int[] sortedSquares(int[] nums) {
        for(int i =0; i < nums.length; i++) {
            nums[i] = (int)Math.pow(nums[i],2);
        }
        Arrays.sort(nums);
        return nums;
    }

    /**
     * 法二 —— 双指针法
     */
    public int[] sortedSquares2(int[] nums) {
        //找到正负数分界点
        int len = nums.length,bound = len - 1;
        for(int i = 0; i < len; i++) {
            if(nums[i] >= 0) {
                bound = i;
                break;
            }
        }

        //非负数阵营与正数阵营一一比对并插入结果数组
        int right = bound,left = bound - 1,count = 0;
        int[] results = new int[len];
        while((left >= 0) || (right < len)) {
            //余数补全
            if(left < 0) {
                results[count] = nums[right]*nums[right];
                right++;
            } else if(right == len) {
                results[count] = nums[left]*nums[left];
                left--;
            } else if(-nums[left] >= nums[right]) {
                results[count] = nums[right]*nums[right];
                right++;
            } else {
                results[count] = nums[left]*nums[left];
                left--;
            }
            count++;
        }

        return results;
    }

    /**
     * 法三 —— 双指针法
     */
    public int[] sortedSquares3(int[] nums) {
        int length = nums.length,head = 0, tail = length - 1,count = length - 1;
        int[] results = new int[length];
        while(count >= 0) {
            int squareHead = nums[head]*nums[head];
            int squareTail = nums[tail]*nums[tail];
            if(squareHead >= squareTail) {
                results[count] = squareHead;
                head++;
            } else {
                results[count] = squareTail;
                tail--;
            }
            count--;
        }
        return results;
    }
}

class SortedSquaresTest {
    public static void main(String[] args) {
        int[] nums = new int[]{-4,-3,-1,0,8,9};
        int[] results = new SortedSquares().sortedSquares(nums);
        System.out.println("法一："+Arrays.toString(results));

        int[] nums2 = new int[]{-4,-3,-1};
        int[] results2 = new SortedSquares().sortedSquares2(nums2);
        System.out.println("法二："+Arrays.toString(results2));

        int[] nums3 = new int[]{-4,-3,-1,1,2};
        int[] results3 = new SortedSquares().sortedSquares3(nums3);
        System.out.println("法二："+Arrays.toString(results3));
    }
}