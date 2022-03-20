package com.nowcoder.community.config;

import com.nowcoder.community.Quartz.AlphaJob;
import com.nowcoder.community.Quartz.PostScoreRefreshJob;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

//配置->初始化数据库->以后在数据库中调用
@Configuration
public class QuartzConfig {
    //beanFactory:容器的顶层接口
    //FactoryBean:简化bean的实例过程：
    //1.spring通过FactoryBean封装了Bean的实例化过程
    //2.将FactoryBean装配到spring容器中
    //3.将FactoryBean注入到其他bean中
    //4.其他的Bean得到的是FactoryBean所管理的对象实例


    //配置jobdetail
   // @Bean
    public JobDetailFactoryBean alphaJobDetail(){
        JobDetailFactoryBean factoryBean=new JobDetailFactoryBean();
        factoryBean.setJobClass(AlphaJob.class);
        factoryBean.setName("alphaJob");
        factoryBean.setGroup("alphaGroup");
        factoryBean.setDurability(true); //任务长久保存
        factoryBean.setRequestsRecovery(true);//任务可恢复
        return factoryBean;
    }
    //配置Trigger(SimpleTriggerFactoryBean,CronTriggerFactoryBean)
   // @Bean
    public SimpleTriggerFactoryBean alphaTrigger(JobDetail alphaJobDetail){
        SimpleTriggerFactoryBean factoryBean=new SimpleTriggerFactoryBean();
        factoryBean.setJobDetail(alphaJobDetail);
        factoryBean.setName("alphaTrigger");
        factoryBean.setGroup("alphaTriggerGroup");
        factoryBean.setRepeatInterval(3000);
        factoryBean.setJobDataMap(new JobDataMap());
        return factoryBean;
    }

    //刷新帖子分数任务
     @Bean
    public JobDetailFactoryBean postScoreRefreshJobDetail(){
        JobDetailFactoryBean factoryBean=new JobDetailFactoryBean();
        factoryBean.setJobClass(PostScoreRefreshJob.class);
        factoryBean.setName("postScoreRefreshJob");
        factoryBean.setGroup("communityJobGroup");
        factoryBean.setDurability(true); //任务长久保存
        factoryBean.setRequestsRecovery(true);//任务可恢复
        return factoryBean;
    }

     @Bean
    public SimpleTriggerFactoryBean postScoreRefreshTrigger(JobDetail postScoreRefreshJobDetail){
        SimpleTriggerFactoryBean factoryBean=new SimpleTriggerFactoryBean();
        factoryBean.setJobDetail(postScoreRefreshJobDetail);
        factoryBean.setName("postScoreRefreshJobDetail");
        factoryBean.setGroup("communityTriggerGroup");
        factoryBean.setRepeatInterval(1000*60*5);
        factoryBean.setJobDataMap(new JobDataMap());
        return factoryBean;
    }
}
