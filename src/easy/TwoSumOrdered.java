package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Abby
 * 167.两数之和 II - 输入有序数组（下标从1开始计数）
 */
public class TwoSumOrdered {
    /**
     * 法一 —— 哈希表查找
     * @param numbers 目标所在数组
     * @param target 两数之和
     * @return int[] 两个数所在的下标
     */
    public int[] twoSum(int[] numbers, int target) {
        int length = numbers.length;
        Map<Integer,Integer> hashmap = new HashMap<>();
        hashmap.put(numbers[0],0);
        int data2 = 0;
        for (int i = 1; i < length; i++) {
            data2 = target - numbers[i];
            if (hashmap.containsKey(data2)) {
                return new int[]{hashmap.get(data2) + 1,i + 1};
            } else {
                hashmap.put(numbers[i], i);
            }
        }
        return new int[]{};
    }

    /**
     * 法二 —— 二分查找法
     */
    public int[] twoSum2(int[] numbers, int target) {
        int length = numbers.length;
        int data2 = 0;
        int high = length - 1;
        for (int i = 0; i < length; i++) {
            data2 = target - numbers[i];
            int low = i + 1;
            while ( low <= high ) {
                int middle = low + (high - low) / 2;
                if (data2 == numbers[middle]) {
                    return new int[]{i + 1, middle + 1};
                } else  if(data2 > numbers[middle]) {
                    low = middle + 1;
                } else {
                    high = middle - 1;
                }
            }
        }
        return new int[]{};
    }

    /**
     * 法三 —— 双指针（缩减搜索空间）✔★
     * 每判断一次就能缩减一行/列
     */
    public int[] twoSum3(int[] numbers, int target) {
        int length = numbers.length;
        int i = 0, j = length - 1;
        while (i < length && j < length) {
            if(numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            } else  if(numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{-1,-1};
    }


}

class TwoSumOrderedTest {
    public static void main(String[] args) {
        int[] numbers = new int[]{1,2,4,7,9};
        int target = 9;
        TwoSumOrdered twoSumOrdered = new TwoSumOrdered();
        int[] results = twoSumOrdered.twoSum(numbers,target);
        int[] results2 = twoSumOrdered.twoSum2(numbers,target);
        int[] results3 = twoSumOrdered.twoSum3(numbers,target);
        System.out.println(Arrays.toString(results));
        System.out.println(Arrays.toString(results2));
        System.out.println(Arrays.toString(results3));
    }
}

