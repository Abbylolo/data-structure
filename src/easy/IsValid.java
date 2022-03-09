package easy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author Abby
 * @date 2022/03/09
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。左括号必须以正确的顺序闭合。
 *
 * 输入：s = "{[]}"  输出：true
 * 输入：s = "()[]{}" 输出：true
 **/
public class IsValid {
    /**
     * 法一：栈
     * 思路：栈先进后出，HashMap键值对判断是否为一对。
     * 遇到左括号入栈，遇到右括号判断和栈顶出栈的是否匹配，匹配则出栈左括号。遍历完毕看栈是否为空.
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        int len = s.length();
        if(len % 2 !=0) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>(3){
            {
                put(')','(');
                put(']','[');
                put('}','{');
            }
        };
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // 检测到右部
            if(pairs.containsKey(c)) {
                // 判断是否对称
                if(stack.isEmpty() || !stack.peek().equals(pairs.get(c))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        System.out.println(isValid.isValid("()[]{}"));
    }
}
