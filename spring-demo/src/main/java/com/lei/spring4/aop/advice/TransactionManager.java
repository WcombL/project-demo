package com.lei.spring4.aop.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class TransactionManager implements ThrowsAdvice {

    // 前3个参数要么都提供，要么都不提供
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable {
        System.out.println("-----------");
        System.out.println("method:" + method.getName());
        System.out.println("抛出异常:" + ex.getMessage());
        System.out.println("成功回滚事务。");
    }
}
