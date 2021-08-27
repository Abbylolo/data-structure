package middle;

import java.util.Arrays;

/**
 * 189.旋转数组
 * 双指针
 * @author Abby
 */
public class Rotate {
    /**
     * 法一：暴力解法 - 使用额外的数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * @param nums 数组
     * @param k 移动的位置长度
     */
    public void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] results = new int[length];
        for (int order = 0; order < length; order++) {
            results[(order+k)%length] = nums[order];
        }
        System.arraycopy(results,0,nums,0,length);
    }

    /**
     * 法二：数组翻转✔
     * 翻转所有元素 → 翻转 [0, k mod n - 1]区间的元素 → 翻转 [k mod n, n - 1]区间的元素
     */
    public void rotate2(int[] nums, int k) {
        int length = nums.length;
        int move = k % length;
        reverse(nums,0,length - 1);
        reverse(nums,0,move - 1);
        reverse(nums,move,length - 1);
    }

    /**
     * 翻转数组的指定区间
     * @param nums 需要翻转的一维数组
     * @param begin 区间左侧
     * @param end 区间右侧
     */
    public void reverse(int[] nums,int begin,int end) {
        for(int i = 0; i < (end - begin + 1) / 2; i++) {
            int temp = nums[begin + i];
            nums[begin + i] = nums[end - i];
            nums[end - i] = temp;
        }
    }

    /**
     * 法三：环状替换法
     * 替换完成的判定：所有元素替换过/循环了最大公约数gcd(n,k)次
     */
    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        int circle = gcd(k,n);
        for(int i = 0; i < circle; i++) {
            int next = (i + k) % n;
             do{
                int temp = nums[next];
                nums[next] = nums[i];
                nums[i] = temp;
                next = (next + k) % n;
            }while(next != i);
        }
    }

    /**
     * 求最大公约数
     * @param x 数字1
     * @param y 数字2
     * @return 数字1和2的最大公约数
     */
    public int gcd(int x, int y) {
        return y>0?gcd(y,x%y):x;
    }
}

class RotateTest {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,-100,3,99};
        int[] nums2 = new int[]{-1,-100,3,99};
        int[] nums3 = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        Rotate r = new Rotate();
        r.rotate(nums,k);
        r.rotate2(nums2,k);
        r.rotate3(nums3,k);
        System.out.println("法一："+Arrays.toString(nums));
        System.out.println("法二："+Arrays.toString(nums2));
        System.out.println("法三："+Arrays.toString(nums3));
    }
}