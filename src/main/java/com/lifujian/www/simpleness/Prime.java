package com.lifujian.www.simpleness;

/**
 * @author lifujian  2017年11月29日
 * @Description: 素数。即质数，大于1，且只有1和本身两个公约数的自然数。
 *               判断给定的数是否素数。
 */
public class Prime {
    
    public static boolean isPrime (int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i*i <= x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }
}
