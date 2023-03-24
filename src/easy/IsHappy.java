package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 * 「快乐数」定义为：
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 * 输入：n = 19  输出：true
 * @author abbylolo
 * @date 2023/02/18
 */
public class IsHappy {
    public static void main(String[] args) {
        IsHappy isHappy = new IsHappy();
        System.out.println(isHappy.isHappy1(7));
    }

    /**
     * 法一：使用哈希集合检测循环
     * 解析：每次计算出的数字串为链表,下一个数在链路中是否存在。将每次生成的平方和存入哈希集合，一旦重复即存在循环
     * @param n 正整数
     * @return 是否为快乐数（是true 否false）
     */
    public boolean isHappy(int n) {
        Set<Integer> nums = new HashSet<>();
        while (n != 1 && !nums.contains(n)) {
            nums.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    /**
     * 获取下一个数
     * @param num 正整数
     * @return 平方和
     */
    private int getNext(int num) {
        int res = 0;
        while(num > 0) {
            res += Math.pow(num % 10, 2);
            num /= 10;
        }
        return res;
    }

    /**
     * 法二：快慢指针法（弗洛伊德循环查找算法）🌟
     * 算法解释：这个算法是两个指针，一个跑的快，一个跑得慢。乌龟在链表中前进 1 个节点，兔子前进 2 个节点。不管乌龟和兔子在循环中从哪里开始，它们最终都会相遇。这是因为兔子每走一步就向乌龟靠近一个节点（在它们的移动方向上）。
     * 解析：每次计算出的数字串为链表,是否存在循环链路。1⃣️n为快乐数：快跑者先到1 2⃣️n不是快乐数：快跑者和慢跑者会相遇
     */
    public boolean isHappy1(int n) {
        int slow = n,fast = getNext(n);
        while(fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }
}
