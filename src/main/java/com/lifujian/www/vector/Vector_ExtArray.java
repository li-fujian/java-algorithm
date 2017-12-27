package com.lifujian.www.vector;

/**
 * @author lifujian  2017年12月27日
 * @Description: 用 可扩展数组（Extendable array） 实现向量
 * 
 * 定理：基于可扩充数组实现的向量，每次数组扩容的分摊运行时间为O(1)。
 * 
 */
public class Vector_ExtArray implements Vector {
    
    private int N = 8;  // 数组的容量  要可扩展，不能再用 final 修饰
    private int n = 0;  // 向量的实容量
    
    private Object[] A;  // 对象数组
    
    public Vector_ExtArray() {
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
        
        if (n >= N) {  // 此时便需要扩展了
            N *= 2;
            Object B[] = new Object[N];
            for (int i = 0; i < n; i++) {
                B[i] = A[i];
            }
            A = B; // 只是将引用改向B
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


