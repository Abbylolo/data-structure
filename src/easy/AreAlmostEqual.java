package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 1790. 仅执行一次字符串交换能否使两个字符串相等
 * 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
 * 输入：s1 = "bank", s2 = "kanb"  输出：true
 * @author abbylolo
 * @date 2023/02/18
 */
public class AreAlmostEqual {
    public static void main(String[] args) {
        AreAlmostEqual areAlmostEqual = new AreAlmostEqual();
        System.out.println(areAlmostEqual.areAlmostEqual("bank","kanb"));
    }

    /**
     * @param s1 字符串1
     * @param s2 字符串2
     * @return 仅执行一次字符串交换能否使两个字符串相等（能true 不能false)
     */
    public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> diff = new ArrayList<>();
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                if(diff.size() >= 2) {
                    return false;
                }
                diff.add(i);
            }
        }
        if(diff.size() == 0) {
            return true;
        }else if(diff.size() == 1) {
            return false;
        } else {
            return s1.charAt(diff.get(0)) == s2.charAt(diff.get(1)) && s1.charAt(diff.get(1)) == s2.charAt(diff.get(0));
        }
    }
}
