package easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1.两数之和
 * 哈希表查找
 * @author Abby
 */
public class TwoSum {

    /**
     * 法一：暴力枚举
     * 时间复杂度：O(N^2) 空间复杂度：O(1)
     */
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for(int i=0; i<len; i++) {
            for(int j=i+1; j<len; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 法二：查找表法 —— 哈希表✔
     * 在哈希表中查找是否有target-nums[i]
     * [将寻找 target - x 的时间复杂度降低到从 O(N)O(N) 降低到 O(1)O(1)]
     * 以空间换时间
     */
    public int[] twoSum2(int[] nums,int target) {
        HashMap<Integer,Integer> hash = new HashMap(nums.length);
        for(int i = 0; i < nums.length; i++) {
            if(hash.containsKey(target - nums[i])) {
                return new int[]{hash.get(target - nums[i]), i};
            }
            hash.put(nums[i],i);
        }
        return new int[]{0};
    }
}

class TwoSumTest {
    public static void main(String[] args) {
        int[] nums = {2,7};
        int target = 9;
        int[] results = new TwoSum().twoSum(nums,target);
        System.out.println("法一："+Arrays.toString(results));
        int[] results2 = new TwoSum().twoSum2(nums,target);
        System.out.println("法二："+Arrays.toString(results2));
    }
}