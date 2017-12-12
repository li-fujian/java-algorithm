package com.lifujian.www.queue;

/**
 * @author lifujian  2017年12月12日
 * @Description: 基于位置接口实现的  双向链表 节点
 */
public class DLNode implements Position{
    
    private Object element;  // 数据对象
    
    private DLNode prev;  // 指向前驱节点
    
    private DLNode next;  // 指向后继节点
    
    public DLNode() {
        this(null, null, null);
    }
    
    public DLNode(Object e, DLNode p, DLNode n) {
        element = e;
        prev = p;
        next = n;
    }

    @Override
    public Object getElem() {
        return element;
    }

    @Override
    public Object setElem(Object e) {
        Object oldElem = element;
        element = e;
        return oldElem;
    }
    
    public DLNode getNext() {
        return next;
    }
    
    public DLNode getPrev() {
        return prev;
    }

    public void setNext(DLNode newNext) {
        next = newNext;
    }
    
    public void setPrev(DLNode newPrev) {
        prev = newPrev;
    }
}
