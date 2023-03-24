package easy;

import java.util.Arrays;

/**
 * 1672. 最富有客户的资产总量
 * 输入：accounts = [[1,5],[7,3],[3,5]]  输出：10
 * 解释：
 *     第 1 位客户的资产总量 = 6
 *     第 2 位客户的资产总量 = 10
 *     第 3 位客户的资产总量 = 8
 *     第 2 位客户是最富有的，资产总量是 10
 * @author abbylolo
 * @date 2023/02/20
 */
public class MaximumWealth {
    public static void main(String[] args) {
        int[][] accounts = {{1,5},{7,3},{3,5}};
        MaximumWealth maximumWealth = new MaximumWealth();
        System.out.println(maximumWealth.maximumWealth(accounts));
    }

    /**
     * 法一：遍历
     * @param accounts 各个客户的资产分布
     * @return 最富有客户的资产总量
     */
    public int maximumWealth(int[][] accounts) {
        int maximumWealth = Integer.MIN_VALUE;
        for (int[] account: accounts) {
            maximumWealth = Math.max(maximumWealth, Arrays.stream(account).sum());
        }
        return maximumWealth;
    }
}
