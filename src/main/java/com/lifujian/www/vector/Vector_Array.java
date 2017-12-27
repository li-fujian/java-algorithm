package com.lifujian.www.vector;

/**
 * @author lifujian  2017年12月27日
 * @Description: 用定长数组实现向量
 * 缺陷：容量固定。太小，浪费内存；稍微一大，秩溢出。
 */
public class Vector_Array implements Vector {
    
    private final int N = 1024;  // 数组的容量
    private int n = 0;  // 向量的实容量
    
    private Object[] A;  // 对象数组
    
    public Vector_Array() {
        A = new Object[N];
        n = 0;
    }
    @Override
    public int getSize() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return (n == 0) ? true : false;
    }

    @Override
    public Object getAtRank(int r) throws ExceptionBoundaryViolation {
        if (r < 0 || r >= n) {
            throw new ExceptionBoundaryViolation("意外：秩越界");
        }
        return A[r];
    }

    @Override
    public Object replaceAtRank(int r, Object obj) throws ExceptionBoundaryViolation {
        if (r < 0 || r >= n) {
            throw new ExceptionBoundaryViolation("意外：秩越界");
        }
        Object bak = A[r];
        A[r] = obj;
        return bak;
    }

    @Override
    public Object insertAtRank(int r, Object obj) throws ExceptionBoundaryViolation {
        if (r < 0 || r > n) {
            throw new ExceptionBoundaryViolation("意外：秩越界");
        }
        
        if (n >= N) {
            throw new ExceptionBoundaryViolation("意外：数组溢出"); 
        }
        
        for (int i = n; i > r; i--) {
            A[i] = A[i-1];
        }
        
        A[r] = obj;
        n++;
        return obj;
    }

    @Override
    public Object removeAtRank(int r) throws ExceptionBoundaryViolation {
        if (r < 0 || r >= n) {
            throw new ExceptionBoundaryViolation("意外：秩越界");
        }
        Object bak = A[r];
        for (int i = r; i < n; i++) {
            A[i] = A[i+1];
        }
        n--;
        return bak;
    }

}


