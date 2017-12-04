package com.lifujian.www.simpleness;

/**
 * @author lifujian  2017年11月29日
 * @Description: 一些小方法
 */
public class CommonMethod {

    /**
     * 进制转换，将一个是十进制数转换为任意进制
     * @param x 十进制数
     * @param hex   目标进制
     */
    public static int getAnyHexByDecimal (int x, int hex) {
        StringBuilder res = new StringBuilder();
        while (x != 0) {
            res = res.insert(0, String.valueOf(x%hex));
            x = x / hex;
        }
        return Integer.valueOf(res.toString());
    }
    
    public static void main(String[] args) {
        System.out.println(getAnyHexByDecimal(12,3));
    }
}
