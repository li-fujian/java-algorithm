package com.lifujian.www.leetcode;

/**
 * @author lifujian 2018年2月3日
 * @Description: Given a 32-bit signed integer, reverse digits of an integer.
 *               Input:123,Output:321;Input:-123,Output:-321;Input:120,Output:21
 * @see: https://leetcode.com/problems/reverse-integer/description/
 */
public class Demo007 {

    public static void main(String[] args) {
        int a = 123;
        int b = -1230;
        int c = 120;
        int d = 102;
        System.out.println(mySolution(a));
        System.out.println(mySolution(b));
        System.out.println(mySolution(c));
        System.out.println(mySolution(d));
        System.out.println(reverse(a));
        System.out.println(reverse(b));
        System.out.println(reverse(c));
        System.out.println(reverse(d));
    }

    /**
     * 官网答案
     */
    public static int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }

        return result;
    }

    public static int mySolution(int x) {
        int res = 0;
        while (x != 0) {
            int a = x % 10;
            if (a == 0 && res == 0) {
                x = x / 10;
                continue;
            }
            res = res * 10 + a;
            x = x / 10;
        }
        return res;
    }

}
