package easy;

import java.util.Arrays;

/**
 * 283.移动零
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int count = 0;
        for(int i = 0; i<length; i++) {
            if(nums[i]!=0) {
                nums[count++] = nums[i];
            }
        }
        while(count < length) {
            nums[count++] = 0;
        }
    }
}

class MoveZerosTest {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        MoveZeros mz = new MoveZeros();
        mz.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}