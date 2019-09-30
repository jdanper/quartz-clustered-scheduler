package org.jdanper.kScheduler

import org.quartz.JobBuilder
import org.quartz.SimpleScheduleBuilder
import org.quartz.SimpleTrigger
import org.quartz.TriggerBuilder
import org.quartz.impl.StdSchedulerFactory


fun main(args: Array<String>){

    val schedulerFactory = StdSchedulerFactory()
    val scheduler = schedulerFactory.scheduler

    val job = JobBuilder.newJob(SimpleJob::class.java)
        .withIdentity("myJob2", "group1")
        .build()

    val trigger = TriggerBuilder.newTrigger()
        .withIdentity("myTrigger2", "group1")
        .startNow()
        .withSchedule<SimpleTrigger>(
            SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(1)
                .repeatForever()
        )
        .build()

    if(!scheduler.checkExists(job.key)) {
        scheduler.scheduleJob(job, trigger)
    }

    scheduler.start()
}
