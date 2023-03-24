package easy;

/**
 * 1523. 在区间范围内统计奇数数目
 * 给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
 * 输入：low = 3, high = 7  输出：3
 * @author abbylolo
 * @date 2023/03/15
 *
 */
public class CountOdds {
    public static void main(String[] args) {
        int low = 2, high = 10;
        CountOdds countOdds = new CountOdds();
        System.out.println(countOdds.countOdds(low, high));
    }

    /**
     * 法一：前缀和思想
     * @param low 最低值
     * @param high 最高值
     * @return 奇数个数
     */
    public int countOdds(int low, int high) {
        return pre(high) - pre(low - 1);
    }
    /* 0到x的奇数个数*/
    private int pre(int x)  {
        return (x + 1) >> 1;
        // return (x + 1) / 2;
    }

    public int countOdds1(int low, int high) {
        if(low % 2 == 0 && high % 2 == 0) {
            return (high - low) /2;
        } else {
            return (high - low) /2 + 1;
        }
    }
}
