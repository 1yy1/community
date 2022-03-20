package com.nowcoder.community;

import com.nowcoder.community.service.AlphaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.concurrent.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class ThreadPoolTests {
    private static final Logger logger= LoggerFactory.getLogger(ThreadPoolTests.class);
    //JDK普通线程池
    private ExecutorService executorService= Executors.newFixedThreadPool(5);
    //JDK可执行定时任务的线程池
    private ScheduledExecutorService scheduledExecutorService=Executors.newScheduledThreadPool(5);

    //Spring 普通线程池
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;
    //Spring可执行定时任务的线程池
    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;
    @Autowired
    private AlphaService alphaService;
    private void sleep(long m){
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    //JDK普通线程池
    @Test
    public void testExecutorService(){
        Runnable task=new Runnable() {
            @Override
            public void run() {
                logger.debug("hello ExecutorService");
            }
        };
        for (int i = 0; i < 10; i++) {
            executorService.submit(task);
        }
        sleep(10000);
    }
    //jdk定时任务
    @Test
    public void testScheduledExecutorService(){
        Runnable tast=new Runnable() {
            @Override
            public void run() {
                logger.debug("hello ScheduledService");
            }
        };
        scheduledExecutorService.scheduleAtFixedRate(tast,10000,1000, TimeUnit.MILLISECONDS);
        sleep(30000);
    }

    //spring普通线程池
    @Test
    public void testThreadPoolTaskExecutor(){
        Runnable tast=new Runnable() {
            @Override
            public void run() {
                logger.debug("hello ThreadPoolExecutor");
            }
        };
        for (int i = 0; i < 10; i++) {
            taskExecutor.submit(tast);
        }
        sleep(10000);
    }
    //Spring定时任务线程池
    @Test
    public void testThreadPoolTaskScheduler(){
        Runnable tast=new Runnable() {
            @Override
            public void run() {
                logger.debug("hello ThreadPoolTaskScheduler");
            }
        };
        Date startTime=new Date(System.currentTimeMillis()+10000);
        taskScheduler.scheduleAtFixedRate(tast,startTime,1000);
        sleep(30000);
    }
    //Spring 普通线程池简化
    @Test
    public void testThreadPoolTaskExecutorSimple(){
    for (int i = 0; i < 10; i++) {
        alphaService.executol();
    }
    sleep(10000);
}
//spring定时任务简化
    @Test
    public void testThreadPoolTaskSchedulerSimple(){
        sleep(30000);
    }
}
