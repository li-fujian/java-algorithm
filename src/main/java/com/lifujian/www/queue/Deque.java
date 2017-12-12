package com.lifujian.www.queue;

/**
 * @author lifujian 2017年12月12日
 * @Description: 双端队列接口
 */
public interface Deque {
    public int getSize();

    public boolean isEmpty();

    /**
     * 取首元素，但不删除
     * @return
     * @throws ExceptionQueueEmpty
     */
    public Object first() throws ExceptionQueueEmpty;

    public Object last() throws ExceptionQueueEmpty;

    public void insertFirst(Object obj);

    public void insertLast(Object obj);

    /**
     * 若非空，则删除首元素，并将其内容返回
     * @return
     * @throws ExceptionQueueEmpty
     */
    public Object removeFirst() throws ExceptionQueueEmpty;

    public Object removeLast() throws ExceptionQueueEmpty;

    /**
     * 遍历
     */
    public void Traversal();
}
