package easy;

import java.util.*;

/**
 * 496. 下一个更大元素 I
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 * 输入：nums1 = [4,1,2], nums2 = [1,3,4,2].  输出：[-1,3,-1]
 * @author abbylolo
 * @date 2023/02/19
 */
public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2}, nums2 = {1,3,4,2};
        NextGreaterElement nextGreaterElement = new NextGreaterElement();
        System.out.println(Arrays.toString(nextGreaterElement.nextGreaterElement(nums1, nums2)));
    }

    /**
     * 法一：单调栈 + 哈希表🌟【单调栈解决 Next Greater Number 一类问题】
     * 思路：1⃣️遍历nums2找到每个数字的右边最大数➡单调栈高效找到 ➕ 2⃣️存储1的结果➡HashMap键值对存储。
     * 时间复杂度：O(m+n) 空间复杂度：O(n)【存储哈希表】
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 数组1的下一个更大元素数组（不存在的填-1）
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            while(!stack.isEmpty() && num > stack.peek()) {
                stack.pop();
            }
            hashMap.put(num, stack.isEmpty() ? -1 : stack.peek());
            stack.push(num);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = hashMap.get(nums1[i]);
        }
        return res;
    }

    /**
     * 法二：暴力枚举
     * 时间复杂度：O(mn) 空间复杂度：O(1)
     */
    public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            boolean flag = false;
            for(int j = 0; j < nums2.length; j++) {
                if(flag && nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
                if(nums2[j] == nums1[i]) {
                    flag = true;
                }
            }
            if(res[i] == 0) {
                res[i] = -1;
            }
        }
        return res;
    }
}
