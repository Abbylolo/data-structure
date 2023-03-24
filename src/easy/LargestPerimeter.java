package easy;

import java.util.Arrays;

/**
 * 976. 三角形的最大周长
 * 给定由一些正数（代表长度）组成的数组 nums ，返回 由其中三个长度组成的、面积不为零的三角形的最大周长 。如果不能形成任何面积不为零的三角形，返回 0。
 * 输入：nums = [1,2,1,10]  输出：0
 * @author abbylolo
 * @date 2023/02/17
 */
public class LargestPerimeter {
    public static void main(String[] args) {
        int[] nums = {1,2,1,10};
        LargestPerimeter largestPerimeter = new LargestPerimeter();
        System.out.println(largestPerimeter.largestPerimeter(nums));
    }

    /**
     * 法一：贪心+排序
     * 解析：若a<=b<=c,要想形成三角形必须满足：a+b>c ➡ 升序数组中必须满足：A[i-2]+A[i-1]>A[i]。求最大周长，故从数组尾开始
     * @param nums 正数数组
     * @return 最大周长
     */
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i = nums.length - 1; i >= 2; i--) {
            if(nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }
}
