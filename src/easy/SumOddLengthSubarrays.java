package easy;

/**
 * 1588. 所有奇数长度子数组的和
 * 给你一个正整数数组 arr ，请你计算所有可能的奇数长度子数组的和。
 * 子数组 定义为原数组中的一个连续子序列。
 * 请你返回 arr 中 所有奇数长度子数组的和。
 * 输入：arr = [1,4,2,5,3]  输出：58
 * @author abbylolo
 * @date 2023/02/20
 */
public class SumOddLengthSubarrays {
    public static void main(String[] args) {
        int[] arr = {1,4,2,5,3};
        SumOddLengthSubarrays sumOddLengthSubarrays = new SumOddLengthSubarrays();
        System.out.println(sumOddLengthSubarrays.sumOddLengthSubarrays2(arr));
    }

    /**
     * 法一：暴力枚举
     * 时间复杂度：O(n^3) 空间复杂度O(1)
     * 思路：计算每个子数组的和，再求和
     * @param arr 正整数数组
     * @return 所有奇数长度子数组的和
     */
    public int sumOddLengthSubarrays(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            // 每个奇数子数组
            for (int gap = 0; gap + i < arr.length; gap+=2) {
                // 奇数子数组和
                for(int j = i; j <= gap + i; j++) {
                    sum += arr[j];
                }
            }
        }
        return sum;
    }

    /**
     * 法二：前缀和🌟
     * 思路：计算每个子数组的和，再求和。优化求子数组和的过程
     * 时间复杂度：O(n^2) 空间复杂度：O(n)
     */
    public int sumOddLengthSubarrays1(int[] arr) {
        // 前缀和数组
        int[] prefixSum = new int[arr.length + 1];
        prefixSum[0] = 0;
        for(int i = 0; i < arr.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        int sum = 0;
        for(int m = 0; m < arr.length; m++) {
            for (int gap = 0; m + gap < arr.length; gap += 2) {
                sum += prefixSum[m + gap + 1] - prefixSum[m];
            }
        }
        return sum;
    }

    /**
     * 法三：数学🌟🌟
     * 思路：元素✖️该元素在奇数子数组出现次数（数学）
     * 解析：如果元素 arr[i] 在一个长度为奇数的子数组中，则在该子数组中，元素 arr[i] 的左边和右边的元素个数一定同为奇数或同为偶数（注意 0 也是偶数）。
     * 时间复杂度：O(n) 空间复杂度O(1)
     */
    public int sumOddLengthSubarrays2(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            // 当元素arr[i]左边右边同时为奇数时的子数组个数
            int leftCount = i, rightCount = arr.length - i - 1;// 元素左边的数字个数和右边的数字个数
            int leftOdds = (leftCount + 1) / 2, rightOdds = (rightCount + 1) / 2; // [0, leftCount]中奇数的个数
            int odds = leftOdds * rightOdds; // 左边右边同时为奇数时的子数组个数(排列组合)

            // 当元素arr[i]左边右边同时为偶数时的子数组个数
            int leftEvens = (leftCount / 2) + 1, rightEvens = (rightCount / 2) + 1;// [0, leftCount]中偶数的个数
            int evens = leftEvens * rightEvens;

            sum += arr[i] * (odds + evens);
        }
        return sum;
    }
}
