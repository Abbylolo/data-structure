package interview.beginning;

import java.util.HashSet;
import java.util.Set;

/**
 * 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1: 输入: [2,2,1] 输出: 1
 * @author Abby
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] num = {2,3,2,3,4,4,1,1,7,9,9};
        System.out.println(new SingleNumber().singleNumber1(num));
        System.out.println(new SingleNumber().singleNumber2(num));
        System.out.println(new SingleNumber().singleNumber3(num));
    }

    /**
     * no法1：双层循环遍历。将重复出现的位置重新赋值为-1以标记重复，以减少比较次数。
     * @param nums 非空整数数组
     * @return 只出现一次的数字
     */
    public int singleNumber1(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[0]) {
                continue;
            }
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    nums[i] = nums[0];
                    nums[j] = nums[0];
                    break;
                }
            }
        }
        for(int i : nums) {
            if(i != nums[0]) {
                return i;
            }
        }
        return nums[0];
    }

    /**
     * 法二：位运算
     * 异或运算(同0异1)：a^a=0; a^0=a; 交换律 a^b^c=a^c^b
     * @param nums 非空整数数组
     * @return 只出现一次的数字
     */
    public int singleNumber2(int[] nums) {
        int result = 0;
        for(int i : nums) {
            result ^= i;
        }
        return result;
    }


    /**
     * 法三：集合运算
     * 利用集合set的非重复性。重复数据无法加入集合，加入失败的即重复的移除
     * @param nums
     * @return
     */
    public int singleNumber3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if(!set.add(i)) {
                set.remove(i);
            }
        }
        return (int) set.toArray()[0];
    }
}
