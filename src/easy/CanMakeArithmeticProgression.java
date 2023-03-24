package easy;

import java.util.Arrays;

/**
 * 1502. 判断能否形成等差数列
 * 给你一个数字数组 arr 。
 * 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
 * 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
 * 输入：arr = [3,5,1] 输出：true
 * @author abbylolo
 * @date 2023/02/18
 */
public class CanMakeArithmeticProgression {
    public static void main(String[] args) {
        int[] arr = {3,5,1};
        CanMakeArithmeticProgression canMakeArithmeticProgression = new CanMakeArithmeticProgression();
        System.out.println(canMakeArithmeticProgression.canMakeArithmeticProgression(arr));
    }

    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        for(int i = 1; i < arr.length - 1; i++) {
            if(arr[i] * 2 != arr[i - 1] + arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean canMakeArithmeticProgression1(int[] arr) {
        Arrays.sort(arr);
        int gap = arr[1] - arr[0];
        for(int i = 1; i < arr.length - 1; i++) {
            if(arr[i] + gap != arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
