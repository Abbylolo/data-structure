package easy;

/**
 * 1822. 数组元素积的符号
 * 已知函数 signFunc(x) 将会根据 x 的正负返回特定值：
 *  如果 x 是正数，返回 1 。
 *  如果 x 是负数，返回 -1 。
 *  如果 x 是等于 0 ，返回 0 。
 * 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
 * 返回 signFunc(product) 。
 * 输入：nums = [-1,-2,-3,-4,3,2,1]  输出：1
 * @author abbylolo
 * @date 2023/02/18
 */
public class ArraySign {
    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,3,2,1};
        ArraySign arraySign = new ArraySign();
        System.out.println(arraySign.arraySign(nums));
    }

    /**
     * @param nums 整数数组
     * @return 数组元素积的符号（正1 零0 负-1）
     */
    public int arraySign(int[] nums) {
        int sign = 1;
        for(int num : nums) {
            if(num == 0) {
                sign = 0;
                break;
            }else if(num < 0) {
                sign = -sign;
            }
        }
        return sign;
    }
}
