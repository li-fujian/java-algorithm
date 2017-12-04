package com.lifujian.www.tree;

/**
 * @author lifujian  2017年12月4日
 * @Description: 二叉树的简单实现 及遍历（先根遍历、中根遍历、后根遍历） 
 */
public class BTree {
    private int data;  // 根节点数据
    private BTree left;  // 左子树
    private BTree right;  // 又子树
    
    public BTree(int data) {
        super();
        this.setData(data);
        setLeft(null);
        setRight(null);
    }
    
    /**
     * 插入节点
     * @param root 根节点
     * @param data  待插入节点的 data
     */
    public void insert(BTree root, int data) {
        if (data > root.getData()) {
            if (root.getRight() == null) {
                root.setRight(new BTree(data));
            } else {
                this.insert(root.getRight(), data);
            }
        } else {
            if (root.getLeft() == null) {
                root.setLeft(new BTree(data));
            } else {
                this.insert(root.getLeft(), data);
            }
        }
    }
    
    public static void main(String[] args) {
        /*
         *          8
         *       /     \
         *      4       15
         *    /   \       \
         *   2     6       18 
         *        / \ 
         *       5   7 
         */
        int[] array = {8,4,2,6,5,7,15,18};
        BTree root = new BTree(8);
        for (int i = 1; i < array.length; i++) {
            root.insert(root, array[i]);
        }
        
        // 遍历
        System.out.println("\n----先根遍历-----");
        preOrder(root);
        System.out.println("\n----中根遍历-----");
        inOrder(root);
        System.out.println("\n----后根遍历-----");
        postOrder(root);

    }
    
    /**
     * 先根遍历
     */
    public static void preOrder(BTree root) {
        if (root != null) {
            System.out.print(root.getData() + "-");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }
    
    /**
     * 中根遍历
     */
    public static void inOrder(BTree root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.print(root.getData() + "-");
            inOrder(root.getRight());
        }
    }
    
    /**
     * 后根遍历
     */
    public static void postOrder(BTree root) {
        if (root != null) {
            inOrder(root.getLeft());
            inOrder(root.getRight());
            System.out.print(root.getData() + "-");
        }
    }

    public BTree getLeft() {
        return left;
    }

    public void setLeft(BTree left) {
        this.left = left;
    }

    public BTree getRight() {
        return right;
    }

    public void setRight(BTree right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}

/**
 * B树，又名二叉搜索树：非叶子结点的左指针指向小于其关键字的子树，右指针指向大于其关键字的子树
 * 如果B树的所有非叶子结点的左右子树的结点数目均保持差不多（平衡），那么B树的搜索性能逼近二分查找
 *    但它比连续内存空间的二分查找的优点是，改变B树结构（插入与删除结点）不需要移动大段的内存数据，甚至通常是常数开销
 * 实际使用的B树都是在原B树的基础上加上平衡算法，即“平衡二叉树”
 * 
 */

















