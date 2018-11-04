package com.lei.spring4.aop;

import com.lei.spring4.aop.introduce.ForumService;
import com.lei.spring4.aop.introduce.Monitorable;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IntroduceTest {

    @Test
    public void introduce(){
        String configPath = "com/lei/aop/introduce.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(configPath);
        ForumService forumService = (ForumService)ctx.getBean("forumService");
        forumService.removeForum(10);
        forumService.removeTopic(1022);
        Monitorable moniterable = (Monitorable)forumService;
        moniterable.setMonitorActive(true);
        forumService.removeForum(10);
        forumService.removeTopic(1022);
    }
}
