package com.lifujian.www.demo;

import java.util.ArrayList;
import java.util.List;

import com.lifujian.www.tree.BTree;

/**
 * @author lifujian  2017年12月4日
 * @Description: 打印出二叉树每层最左（右）侧的数据。(美团面试题)
 */
public class BinaryTree01 {
    
    public static void main(String[] args) {
        /*
         *          8
         *       /     \
         *      4       15
         *    /   \       \
         *   2     6       18 
         *        / \ 
         *       5   7 
         *  每层最左侧为 8，4，2，5
         *  右侧为 8，15，18，7
         */
        // 构造二叉树
        int[] array = {8,4,2,6,5,7,15,18};
        BTree root = new BTree(8);
        for (int i = 1; i < array.length; i++) {
            root.insert(root, array[i]);
        }
        
        // 打印
        List<Integer> listRes = new ArrayList<Integer>();
        List<BTree> listRoot = new ArrayList<BTree>();
        if (root != null) {
            listRoot.add(root);
            listRes.add(root.getData());
            myOrder(listRoot, listRes);
        }
        for (Integer i : listRes) {
            System.out.print(i + ",");
        }
    }
    
    public static void myOrder(List<BTree> list, List<Integer> listRes) {
        List<BTree> listNext = new ArrayList<BTree>();
        if (list != null && !list.isEmpty()) {
            for (BTree bt : list) {
                if (bt.getLeft() != null) {
                    listNext.add(bt.getLeft());
                }
                if (bt.getRight() != null) {
                    listNext.add(bt.getRight());
                }
            }
        }
        if (!listNext.isEmpty()) {
            listRes.add(listNext.get(0).getData());
            myOrder(listNext, listRes);
        }
    }
}
