package easy;

/**
 * 1281. 整数的各位积和之差
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 * 输入：n = 234  输出：15
 * @author abbylolo
 * @date 2023/06/16
 */
public class SubtractProductAndSum {
    public static void main(String[] args) {
        SubtractProductAndSum subtractProductAndSum = new SubtractProductAndSum();
        System.out.println(subtractProductAndSum.subtractProductAndSum(234));
    }

    /**
     * 法一：模拟法
     * @param n 整数
     * @return 积和差
     */
    public int subtractProductAndSum(int n) {
        int sum = 0, multiple = 1;
        while(n > 0) {
            sum += n % 10;
            multiple *= n % 10;
            n /= 10;
        }
        return multiple - sum;
    }

    public int subtractProductAndSum1(int n) {
        String str = Integer.toString(n);
        int sum = 0, multiple = 1;
        for(int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - '0';
            multiple *= str.charAt(i) - '0';
        }
        return multiple - sum;
    }
}
