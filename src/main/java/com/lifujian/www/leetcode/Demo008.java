package com.lifujian.www.leetcode;

/**
 * @author lifujian 2018年2月3日
 * @Description: Implement atoi to convert a string to an integer.
 * @see: https://leetcode.com/problems/string-to-integer-atoi/description/
 */
public class Demo008 {

    public static void main(String[] args) {
        String str1 = "1234";
        String str2 = "-1234";
        String str3 = " 00123400";
        String str4 = "340044";
        String str5 = "4124134252352323";
        String str6 = "412412adaabcd";
        System.out.println(reverse(str1));
        System.out.println(reverse(str2));
        System.out.println(reverse(str3));
        System.out.println(reverse(str4));
        System.out.println(reverse(str5));
        System.out.println(reverse(str6));
        
//        String s = "1234";
//        System.out.println(s.charAt(0));
//        System.out.println('0');
//        System.out.println(s.charAt(0) - '0');
//        System.out.println(10 + s.charAt(0));
//        System.out.println(10 + s.charAt(0) - '0');
    }
    
    /**
     * 官网答案
     */
    public static int reverse(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        str = str.trim();
        char firstChar = str.charAt(0);
        int sign = 1, start = 0, len = str.length();
        long sum = 0;
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < len; i++) {
            if (!Character.isDigit(str.charAt(i))) {
                break;
//                return (int)sum*sign;
            }
            sum = sum * 10 + str.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
		return (int)sum * sign;
    }

    public static int myAtoi(String s) {
		return 0;
    }

}
