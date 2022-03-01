package easy;

import java.util.Arrays;

/**
 * @author Abby
 * @date 2022/03/01
 * 88. 合并两个有序数组
 * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 **/
public class Merge {
    public static void main(String[] args){
        Merge merge = new Merge();
        int[] nums1 = {0}, nums2 = {2};
        merge.merge3(nums1,0,nums2,1);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * 法一 合并排序
     * @param nums1 有序整数数组1
     * @param m 数组1实际数个数
     * @param nums2 有效整数数组2
     * @param n 数组2长度
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 法二：双指针（由左到右）
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int i = 0, j = 0, t=0;
        while(i < m && j <n) {
            temp[t++] = (nums1[i] <= nums2[j]) ? nums1[i++] : nums2[j++];
        }
        while(i < m) {
            temp[t++] = nums1[i++];
        }
        while(j < n) {
            temp[t++] = nums2[j++];
        }
        for(int a = 0; a < m+n; a++) {
            nums1[a] = temp[a];
        }
    }

    /**
     * ✔法三：逆向双指针（由右到左）
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1, i = m - 1, j = n - 1;
        while(j >= 0) {
            // 当nums1为空时，i = -1，若不加限制会数组溢出
            nums1[index--] = (i != -1 && nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
        }
    }
}
