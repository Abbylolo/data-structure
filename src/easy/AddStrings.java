package easy;

/**
 * @author Abby
 * @date 2022/03/01
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * [你不能使用任何內建的用于处理大整数的库（比如 BigInteger），也不能直接将输入的字符串转换为整数形式。]
 *
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 **/
public class AddStrings {
    public static void main(String[] args) {
        String num1 = "11", num2 = "123";
        AddStrings addStrings = new AddStrings();
        System.out.println(addStrings.addStrings2(num1,num2));
    }

    /**
     * 法一：模拟加法过程
     * StringBuffer可变字符串，reverse方法翻转; 'char' - '0'字符型转换为int型
     * @param num1 字符串1
     * @param num2 字符串2
     * @return 两字符串和
     */
    public String addStrings(String num1, String num2) {
        int m = num1.length() - 1, n = num2.length() - 1, carry = 0;
        // 在单线程环境中或无关线程安全，要使用 StringBuilder(快 非线程安全 非同步 java1.5 )。反之，使用 StringBuffer(java1.0) 进行线程安全的操作。
        StringBuilder sum = new StringBuilder();
        while(m >=0 || n >=0) {
            // temp -- 两个数之和
            int temp;
            if(m >=0 && n >=0) {
               temp = (num1.charAt(m--) - '0')+(num2.charAt(n--) - '0') + carry;
            } else if(m >= 0) {
                temp = num1.charAt(m--) - '0' + carry;
            } else {
                temp = num2.charAt(n--) - '0' + carry;
            }
            sum.append(temp % 10);
            carry = temp / 10;
        }
        if(carry == 1) {
            sum.append(1);
        }
        sum.reverse();
        return sum.toString();
    }

    /**
     * 法二：模拟法+补零对齐
     */
    public String addStrings2(String num1, String num2) {
        StringBuilder sum = new StringBuilder();
        int result, carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int x = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int y = (j >= 0) ? num2.charAt(j) - '0' : 0;
            result = x + y +carry;
            carry = result / 10;
            sum.append(result % 10);
        }
        if(carry == 1) {
            sum.append(1);
        }
        sum.reverse();
        return sum.toString();
    }
}
