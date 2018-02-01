package com.lifujian.www.leetcode;

/**
 * @author lifujian  2018年2月1日（***）
 * @Description: Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * @see: https://leetcode.com/problems/longest-palindromic-substring/description/
 */
public class Demo005 {
    
    public static void main(String[] args) {
        String s1 = "cdvcbbciwz";
        System.out.println(longestPalindrome(s1));
    }
    
    /**
     * 官网答案
     */
    public static String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);  // 假设回文串为奇数
            int len2 = expandAroundCenter(s, i, i + 1);  // 假设回文串为偶数，即中心点为两个相同的字符。
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    /**
     * 当作回文数的中心点，同时左移和右移进行比较
     * @return 返回长度
     */
    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

}
