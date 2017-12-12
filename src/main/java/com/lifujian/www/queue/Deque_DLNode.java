package com.lifujian.www.queue;

/**
 * @author lifujian  2017年12月12日
 * @Description: 基于双向链表实现 双端队列 结构      Double-ended queue   (读：deck) 前端和后端都支持插入和删除操作的队列
 * 最前端和最后端分别设置 哑元节点，分别称为 头结点、尾节点，起 哨兵 作用，并可简化编程。它们并不存储实质数据。
 * 可使双端队列的每一方法都在常数时间内完成  O(1)
 * insertFirst(x)、insertLast(x)、removeFirst()、removeLast()、、可能支持 first()、last()、getSize()、isEmty()、Traversal()
 * 
 */
public class Deque_DLNode implements Deque {
    
    protected DLNode header;  // 指向首节点
    protected DLNode trailer; // 指向尾节点
    protected int size;

    public Deque_DLNode() {
        header = new DLNode();
        trailer = new DLNode();
        header.setNext(trailer);
        trailer.setPrev(header);
        size = 0;
    }
    
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    @Override
    public Object first() throws ExceptionQueueEmpty {
        if (isEmpty()) {
            throw new ExceptionQueueEmpty("双端队列为空");
        }
        return trailer.getNext().getElem();
    }

    @Override
    public Object last() throws ExceptionQueueEmpty {
        if (isEmpty()) {
            throw new ExceptionQueueEmpty("双端队列为空");
        }
        return trailer.getPrev().getElem();
    }

    @Override
    public void insertFirst(Object obj) {
        DLNode second = header.getNext();
        DLNode first = new DLNode(obj, header, second);
        second.setPrev(first);
        header.setNext(first);
        size++;
    }

    @Override
    public void insertLast(Object obj) {
        DLNode second = trailer.getPrev();
        DLNode last = new DLNode(obj, second, trailer);
        second.setNext(last);
        trailer.setPrev(last);
        size++;
    }

    @Override
    public Object removeFirst() throws ExceptionQueueEmpty {
        if (isEmpty()) {
            throw new ExceptionQueueEmpty("双端队列为空");
        }
        DLNode first = header.getNext();
        DLNode second = first.getNext();
        header.setNext(second);
        second.setPrev(header);
        size--;
        return first;
    }

    @Override
    public Object removeLast() throws ExceptionQueueEmpty {
        if (isEmpty()) {
            throw new ExceptionQueueEmpty("双端队列为空");
        }
        DLNode last = trailer.getPrev();
        DLNode second = last.getPrev();
        trailer.setPrev(second);
        second.setNext(trailer);
        size--;
        return last;
    }

    @Override
    public void Traversal() {
        DLNode p = header.getNext();
        while (p != trailer) {
            System.out.print(p.getElem() + " ");
            p = p.getNext();
        }
        System.out.println();
    }

}
