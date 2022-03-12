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
     * @param s 括号字符串
     * @return 字符串是否有效
     */
    public boolean isValid(String s) {
        int len = s.length();
        if(len % 2 == 1) {
            return false;
        }
        // 要求1——左右括号配对-HashMap；要求2——正确顺序闭合-栈先进先出
        Map<Character, Character> pairs = new HashMap<Character, Character>();
        pairs.put('(',')');
        pairs.put('{','}');
        pairs.put('[',']');
        Deque<Character> stack = new LinkedList<>();
        for(int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            // 如果遍历到左派括号
            if(pairs.containsKey(ch)) {
                stack.push(ch);
            } else {
                // 遍历到右派括号，判断是否配对，配对则将左括号pop弹出
                // 这个右括号是否和栈顶元素(左括号)所对应的右括号相等
                // 这里判断是否为空是防止右括号比左括号多-{}}
                if(stack.isEmpty() || !pairs.get(stack.peek()).equals(ch)) {
                    return false;
                }
                stack.pop();
            }
        }
        // 这里判断是否为空是防止左括号多出-{{}
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        System.out.println(isValid.isValid("()[{}]{}"));
    }
}
