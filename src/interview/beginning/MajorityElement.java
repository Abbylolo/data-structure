package interview.beginning;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Abby
 * @date 2022/02/09
 * 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于n/2的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1：输入：[3,2,3] 输出：3
 **/
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3,1,1,1,1,4,1,5,3};
        MajorityElement majorityElement = new MajorityElement();
        System.out.println("法一：" + majorityElement.majorityElement(nums));
        System.out.println("法二：" + majorityElement.majorityElement2(nums));
        System.out.println("法三：" + majorityElement.majorityElement3(nums));
        System.out.println("法四：" + majorityElement.majorityElement4(nums));
    }

    /**
     * no。法一：新建一个数组记录个数
     * 前提为数字不为负数。
     * @param nums 整数数组
     * @return 数组中出现次数大于n/2的元素
     */
    public int majorityElement(int[] nums) {
        //threshold - 阈值
        int threshold =  nums.length /  2;
        int[] sums = new int[9];
        for(int i : nums) {
            sums[i]++;
            if(sums[i] > threshold ){
                return i;
            }
        }
        return -1;
    }

    /**
     * 法二：Map值键对——key（数字），value（出现的次数）
     * @param nums 整数数组
     * @return 数组中出现次数大于n/2的元素
     */
    public int majorityElement2(int[] nums) {
        int threshold = nums.length / 2;
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        for(int i : nums) {
            map.put(i,map.getOrDefault(i,0)+1);
            if(map.get(i) > threshold) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 法三：排序法。排序后次数大于一半的数必然处于中间位置。【若不在中间，说明在前半部分或后半部分，那必不可能大于1/2】
     * @param nums 整数数组
     * @return 数组中出现次数大于n/2的元素
     */
    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     *法四：摩尔投票法。类比国家，人口。两两对战相抵，打到最后的那个数字即为超过半数的数字。
     * @param nums 整数数组
     * @return 数组中出现次数大于n/2的元素
     */
    public int majorityElement4(int[] nums) {
        int count = 1;
        int major = nums[0];
        for(int i = 1; i<nums.length; i++) {
            if(count == 0) {
                major = nums[i];
                count = 1;
            } else if(major == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}
