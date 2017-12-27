package com.lifujian.www.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lifujian  2017年12月20日
 * @Description: 在一个字符串中找一个最长的子串,要求此子串没有重复的字符，返回子串的长度即可
 * @see https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
public class Demo003 {

    
    /**
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
    
    public static void main(String[] args) {
        String s1 = "abcabcbb"; // abc  3
        String s2 = "bbbbb";   // b  1
        String s3 = "pwwkew";  // wke 3
        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println(lengthOfLongestSubstring(s3));
    }
    
}
