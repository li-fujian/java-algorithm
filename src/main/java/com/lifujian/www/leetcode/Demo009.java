package com.lifujian.www.leetcode;

/**
 * @author lifujian 2018年2月7日
 * @Description: Determine whether an integer is a palindrome. Do this without extra space.
 *              判断一个数是否是回文数。不能使用额外空间。
 * @see: https://leetcode.com/problems/palindrome-number/description/
 */
public class Demo009 {

    public static void main(String[] args) {
        int  a = 12321;
        int b = 123321;
        int c = 12310;
        int d = 2;
        int e = 0;
        int f = 10;
        int m = Integer.MAX_VALUE;
        System.out.println(mySolution(a));  // true
        System.out.println(mySolution(b));  // true
        System.out.println(mySolution(c));  // false
        System.out.println(mySolution(d));  // true
        System.out.println(mySolution(e));  // true
        System.out.println(mySolution(f));  // false
        System.out.println(mySolution(m));  // false  但反转时 发生了数据溢出
        System.out.println(m);  // 2147483647
    }

    /**
     * 官网答案 TODO
     */
    public static boolean isPalindrome(int x) {
        return false;

    }

    public static boolean mySolution(int x) {
        if (x < 0 || ((x != 0) && (x % 10) == 0)) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        int rev = 0;
        int  y = x;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (y == rev);
    }

}
