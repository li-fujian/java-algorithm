package com.lifujian.www.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lifujian 2018年2月2日
 * @Description: The string "PAYPALISHIRING" is written in a zigzag pattern on a
 *               given number of rows like this: "PAHNAPLSIIGYIR"
 * @see: https://leetcode.com/problems/zigzag-conversion/description/
 */
public class Demo006 {

    public static void main(String[] args) {
        String s1 = "PAYPALISHIRING";
        System.out.println(convert(s1, 2));
    }

    /**
     * 官网答案
     */
    public static String convert(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++)
            sb[i] = new StringBuffer();

        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++)
                // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows - 2; idx >= 1 && i < len; idx--)
                // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }

    public static String mySolution(String s, int numRows) {
        Map<Integer, StringBuffer> m = new HashMap<Integer, StringBuffer>();
        for (Integer i = 1; i <= numRows; i++) {
            m.put(i, new StringBuffer());
        }
        int len = s.length();
        int i = 0;
        while (i < len) {
            for (Integer j = 1; j <= numRows; j++) {
                StringBuffer sb = m.get(j);
                sb.append(s.charAt(i));
                i++;
                if (i >= len) {
                    break;
                }
            }
            if (i >= len) {
                break;
            }
            for (Integer j = numRows - 1; j > 1; j--) {
                StringBuffer sb = m.get(j);
                sb.append(s.charAt(i));
                i++;
                if (i >= len) {
                    break;
                }
            }
        }

        String res = "";
        for (Integer k = 1; k <= numRows; k++) {
            StringBuffer sb = m.get(k);
            res = res + sb.toString();

        }

        return res;
    }

}
