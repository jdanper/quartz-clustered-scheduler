package org.jdanper.kScheduler

import org.quartz.Job
import org.quartz.JobExecutionContext


class SimpleJob : Job {
    override fun execute(arg0: JobExecutionContext) {
        println("This is a quartz job! FROM ::: ${arg0.fireInstanceId}")
    }
}