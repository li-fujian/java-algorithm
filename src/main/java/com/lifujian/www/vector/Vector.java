package com.lifujian.www.vector;

/**
 * @author lifujian  2017年12月27日
 * @Description: 向量接口
 */
public interface Vector {
    
    int getSize();
    
    boolean isEmpty();
    
    Object getAtRank(int r) throws ExceptionBoundaryViolation;
    
    Object replaceAtRank(int r, Object obj) throws ExceptionBoundaryViolation;
    
    Object insertAtRank(int r, Object obj) throws ExceptionBoundaryViolation;
    
    Object removeAtRank(int r) throws ExceptionBoundaryViolation;
}
