package easy;

/**
 * 191. 位1的个数
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * 输入：n = 00000000000000000000000000001011  输出：3
 * @author abbylolo
 * @date 2023/02/17
 */
public class HammingWeight {
    public static void main(String[] args) {
        // java把 0 开头的数字认定为8进制数
        int n = 00000000000000000000000000001011;
        HammingWeight hammingWeight = new HammingWeight();
        System.out.println(hammingWeight.hammingWeight3(n));
    }

    /**
     * 法一：位运算优化⭐️
     * 关键：n&(n - 1),其运算结果恰为把 n 的二进制位中的最低位的 1 变为 0 之后的结果。
     * 解析：因为每次运算会使得 n 的最低位的 1 被翻转，因此运算次数就等于 n 的二进制位中 1 的个数。
     * @param n 无符号整数（以二进制串的形式）
     * @return 其二进制表达式中数字位数为 '1' 的个数
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        return count;
    }

    /**
     * 法二：循环检查二进制位(逐位与运算)
     */
    public int hammingWeight1(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

    /**
     * 法三：Integer.bitCount()源码❤️
     */
    public int hammingWeight3(int n) {
        n = n - ((n >>> 1) & 0x55555555); //0101 n➡每两位表示两位中1的个数：两个二进制位中1的个数（与运算目的是消除进位时高位的影响
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333); //0011 n➡每四位表示：2个两位数所转换的1的个数
        n = (n + (n >>> 4)) & 0x0f0f0f0f; //00001111 n➡每八位表示：2个四位数所转换的1的个数
        n = n + (n >>> 8);
        n = n + (n >>> 16);
        return n & 0x3f; //因为1的位数最多为100000所以直接与0..0111111即可
        //return Integer.bitCount(n);
    }
}
