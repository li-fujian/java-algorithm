package com.lifujian.www.leetcode;

/**
 * @author lifujian  2018年1月31日
 * @Description: There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *               Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * @see: https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 */
public class Demo004 {
    
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        int[] nums3 = {1,2};
        int[] nums4 = {3,4};
        int[] nums5 = {1,3,6,7};
        int[] nums6 = {2,3};
        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(findMedianSortedArrays(nums3, nums4));
        System.out.println(findMedianSortedArrays(nums5, nums6));
    }
    
    /**
     * 官网答案
     */
    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = iMin + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = iMax - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;

    }

    public static double mySolution(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int len = length/2;
        boolean isEven = length%2 == 0 ? true : false;
        int[] num = new int[len + 2];
        int o1 = 0; 
        int o2 = 0;
        int o = 0;
        boolean flag1 = false;
        boolean flag2 = false;
        
        while (o <= len) {
            if (flag1) {
                num[o] = nums2[o2];
                o2++;
                o++;
                continue;
            }
            if (flag2) {
                num[o] = nums1[o1];
                o1++;
                o++;
                continue;
            }
            
            int a = nums1[o1];
            int b = nums2[o2];
            if (a == b) {
                num[o] = a;
                num[++o] = a;
                o1++;
                o2++;
                o++;
            } else if (a > b) {
                num[o] = b;
                o2++;
                o++;
            } else {
                num[o] = a;
                o1++;
                o++;
            }
            if (o1 == nums1.length) {
                flag1 = true;
            }
            if (o2 == nums2.length) {
                flag2 = true;
            }
        }
        
        if (isEven) {
            return (num[len - 1] + num[len])/2.0;
        } else {
            return num[len];
        }
    }
}
