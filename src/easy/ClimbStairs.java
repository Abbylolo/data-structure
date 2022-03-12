package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Abby
 * @date 2022/03/13
 * 70.爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 输入：n = 3    输出：3
 *
 * 总思路：F(n) = F(n-1) + F(n-2)。斐波那契数列。最后一个楼梯只有通过1个台阶或者2个台阶这两种情况，故总方法数为两种情况方法数之和。最后通过1个台阶的方法数为爬n-1阶到楼顶的方法，即F（n-1)
 **/
public class ClimbStairs {
    /**
     * 法一：递归
     * 时间复杂度O(n^2)，空间复杂度O(n)
     * 优：代码简洁清晰 缺：数据冗余。多次函数调用效率低、可能栈溢出性能差。
     * @param n 到楼顶的楼梯数
     * @return 爬到楼顶的方法总数
     */
    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        } else if(n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 法二：自顶向下记忆性递归 -- HashMap
     * 优点：去冗余。时间复杂度O(n)，空间复杂度O(n)
     */
    public int climbStairs2(int n) {
        Map<Integer,Integer> method = new HashMap<>();
        method.put(1,1);
        method.put(2,2);
        if (method.containsKey(n)) {
            return method.get(n);
        } else {
            method.put(n, climbStairs2(n - 1) + climbStairs2(n - 2));
            return method.get(n);
        }
    }

    /**
     * ✔法三：自底向上动态规划（滑动窗口）
     * 动态规划从较小问题的解，由交叠性质，逐步决策出较大问题的解，它是从f(1)往f(10）方向，往上推求解，所以称为自底向上的解法。
     * f(n-1)和f(n-2) 称为 f(n) 的最优子结构；f(n)= f（n-1）+f（n-2）就称为状态转移方程；f(1) = 1, f(2) = 2 就是边界；比如f(10)= f(9)+f(8),f(9) = f(8) + f(7) ,f(8)就是重叠子问题。
     */
    public int climbStairs3(int n) {
        if(n == 1) {
            return 1;
        }
        if(n == 2) {
            return 2;
        }
        int first = 1, second =2, third = 0;
        for(int i = 1; i < n - 1; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs3(5));
    }
}
