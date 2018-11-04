package com.lei.spring4.aop;

import com.lei.spring4.aop.advice.*;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;
import org.springframework.aop.AfterAdvice;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class BeforeAdviceTest {

    @Test
    public void before() {
        Waiter target = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();

        // Spring代理工厂
        ProxyFactory pf = new ProxyFactory();
        // 对指定接口进行代理
        pf.setInterfaces(target.getClass().getInterfaces());
        // 启用优化，针对接口的代理也会使用Cglib
        pf.setOptimize(true);
        // 代理目标
        pf.setTarget(target);
        // 设置代理增强
        pf.addAdvice(advice);

        // 生成代理对象
        Waiter proxy = (Waiter)pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
    }

    @Test
    public void after() {
        Waiter target = new NaiveWaiter();
        AfterAdvice advice = new GreetingAfterAdvice();

        // Spring代理工厂
        ProxyFactory pf = new ProxyFactory();
        // 对指定接口进行代理
        pf.setInterfaces(target.getClass().getInterfaces());
        // 启用优化，针对接口的代理也会使用Cglib
        pf.setOptimize(true);
        // 代理目标
        pf.setTarget(target);
        // 设置代理增强
        pf.addAdvice(advice);

        // 生成代理对象
        Waiter proxy = (Waiter)pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
    }

    @Test
    public void around() {
        Waiter target = new NaiveWaiter();
        MethodInterceptor advice = new GreetingInterceptor();

        // Spring代理工厂
        ProxyFactory pf = new ProxyFactory();
        // 对指定接口进行代理
        pf.setInterfaces(target.getClass().getInterfaces());
        // 启用优化，针对接口的代理也会使用Cglib
        pf.setOptimize(true);
        // 代理目标
        pf.setTarget(target);
        // 设置代理增强
        pf.addAdvice(advice);

        // 生成代理对象
        Waiter proxy = (Waiter)pf.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("Tom");
    }
}
