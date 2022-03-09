package middle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Abby
 * @date 2022/03/01
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 输入: s = "pwwkew"  输出: 3
 **/
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "advdaf";
        LengthOfLongestSubstring lenLongSubStr = new LengthOfLongestSubstring();
        System.out.println(lenLongSubStr.lengthOfLongestSubstring(s));
        System.out.println(lenLongSubStr.lengthOfLongestSubstring2(s));
    }

    /**
     * 法一：滑动窗口List
     * 利用List判断是否包含元素，不包含则加入子串；否则将子串重新赋值为第一个重复元素后的部分+更新最大子串长。
     * @param s 字符串
     * @return 无重复字符的最长子串
     */
    public int lengthOfLongestSubstring(String s) {
        int len = 0;
        char[] str = s.toCharArray();
        List<Character> subString = new ArrayList();
        for(char c : str) {
            if(subString.contains(c)) {
                // 更新记录此次最长子串的长度
                len = Math.max(len, subString.size());
                //更新子串，滑动窗口
                subString = subString.subList(subString.indexOf(c) + 1, subString.size());
            }
            subString.add(c);
        }
        // 比较最后一个子串
        len = Math.max(len, subString.size());
        return len;
    }

    /**
     * 滑动窗口HashMap (Map中不允许重复的键)
     * 以键值对的形式。key-字符，value-索引号.
     * Map.put()方法覆盖功能：map中key是不能重复的，当我们对相同的key进行put操作时，最后一个key对应的value会把前一个相同的value覆盖掉。
     */
    public int lengthOfLongestSubstring2(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int len = 0, start = 0;
        for(int end = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if(hashMap.containsKey(ch)) {
                // 由于map中旧值并未删除，后续正常序列中的值可能和旧值相等，此时start不能改变，故需比较取大
                start = Math.max(start, hashMap.get(ch) + 1);
            }
            // 最后一个key对应的value会把前一个相同的value覆盖。更新索引值。
            hashMap.put(ch,end);
            len = Math.max(len, end - start + 1);
        }
        return len;
    }
}

