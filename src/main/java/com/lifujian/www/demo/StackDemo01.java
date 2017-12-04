package com.lifujian.www.demo;

import java.util.Stack;

/**
 * @author lifujian  2017年12月4日
 * @Description: 实现可以随时获取最小值的栈
 * 栈  后入先出    入push(x)  出 pop()  获取栈顶元素 peek()
 * 
 */
public class StackDemo01<E extends Comparable<E>> {
    Stack<E> stack1 = new Stack<E>();
    Stack<E> stackMin = new Stack<E>();  // 放最小值
    
    /**
     * 新入元素小于等于最小值  最小值改为新入元素；否则，保持最小值不变
     */
    public void push(E e) {
        stack1.push(e);
        if (stackMin.isEmpty() || e.compareTo(stackMin.peek()) <= 0) {
            stackMin.push(e);
        } else {
            stackMin.push(stackMin.peek());
        }
    }
    
    public E pop() {
        if (!stack1.isEmpty() && !stackMin.isEmpty()) {
            E e = stack1.pop();
            stackMin.pop();
            return e;
        } else {
            System.out.println("栈为空了");
            return null;
        }
    }
    
    public E getMin() {
        return stackMin.peek();
    }
    
    
    public static void main(String[] args) {
        StackDemo01<Integer> demo = new StackDemo01<Integer>();
        for (int i = 0; i < 5; i++) {
            demo.push(i);
            System.out.println(demo.getMin());
            demo.pop();
        }
    }

}
