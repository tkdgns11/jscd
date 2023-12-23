//package com.jscd.app.common.config;
//
//import com.jscd.app.facility.service.LockerDeleteJob;
//import com.jscd.app.facility.service.LockerEmailJob;
//import org.quartz.JobDetail;
//import org.quartz.Trigger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
//import org.springframework.scheduling.quartz.JobDetailFactoryBean;
//import org.springframework.scheduling.quartz.SchedulerFactoryBean;
//
//@Configuration
//public class QuartzConfig {
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    @Bean
//    public JobDetailFactoryBean lockerDeleteJob() {
//        JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
//        jobDetailFactory.setJobClass(LockerDeleteJob.class);
//        jobDetailFactory.setDurability(true);
//        return jobDetailFactory;
//    }
//
//    @Bean
//    public JobDetailFactoryBean lockerEmailJob() {
//        JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
//        jobDetailFactory.setJobClass(LockerEmailJob.class);
//        jobDetailFactory.setDurability(true);
//        return jobDetailFactory;
//    }
//
//    @Bean(name = "lockerEmailJobTrigger")
//    public CronTriggerFactoryBean reservationEmailJobTrigger(JobDetail lockerEmailJob) {
//        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
//        trigger.setJobDetail(lockerEmailJob);
//        trigger.setCronExpression("0 0 0 * * ?");
//        return trigger;
//    }
//
//    @Bean(name = "lockerDeleteJobTrigger")
//    public CronTriggerFactoryBean lockerDeleteJobTrigger(JobDetail lockerDeleteJob) {
//        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
//        trigger.setJobDetail(lockerDeleteJob);
//        trigger.setCronExpression("0 0 0 * * ?");
//        return trigger;
//    }
//
//    @Bean
//    public SchedulerFactoryBean schedulerFactory(
//            @Qualifier("lockerEmailJobTrigger") Trigger lockerEmailJobTrigger,
//            @Qualifier("lockerDeleteJobTrigger") Trigger lockerDeleteJobTrigger) {
//        QuartzJobFactory quartzJobFactory = new QuartzJobFactory();
//        quartzJobFactory.setApplicationContext(applicationContext);
//
//        SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
//        schedulerFactory.setJobFactory(quartzJobFactory);
//        schedulerFactory.setTriggers(lockerEmailJobTrigger, lockerDeleteJobTrigger);
//        return schedulerFactory;
//    }
//}