package com.lei.spring4.aop;

import com.lei.spring4.aop.base.CglibProxy;
import com.lei.spring4.aop.base.ForumService;
import com.lei.spring4.aop.base.ForumServiceImpl;
import com.lei.spring4.aop.base.PerformaceHandler;
import org.junit.Test;

import java.lang.reflect.Proxy;

public class TestFromService {

    @Test
    public void test1() {
        // 业务类正常编码的测试
        ForumService forumService = new ForumServiceImpl();
        forumService.removeForum(10);
        forumService.removeTopic(1012);
    }

    @Test
    public void jdkProxy() {
        // 使用JDK动态代理
        ForumService target = new ForumServiceImpl();
        PerformaceHandler handler = new PerformaceHandler(target);
        ForumService proxy = (ForumService) Proxy.newProxyInstance(target
                        .getClass().getClassLoader(),
                target.getClass().getInterfaces(), handler);
        proxy.removeForum(10);
        proxy.removeTopic(1012);
    }

    @Test
    public void cglibProxy() {
        //使用CGLib动态代理
        CglibProxy cglibProxy = new CglibProxy();
        ForumService forumService = (ForumService)cglibProxy.getProxy(ForumServiceImpl.class);
        forumService.removeForum(10);
        forumService.removeTopic(1023);
    }
}
