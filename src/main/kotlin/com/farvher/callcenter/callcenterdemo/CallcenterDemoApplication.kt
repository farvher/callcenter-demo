package com.farvher.callcenter.callcenterdemo

import com.farvher.callcenter.callcenterdemo.services.Dispatcher
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableAsync


@SpringBootApplication
@EnableAsync
open class CallcenterDemoApplication


fun main(args: Array<String>) {
   // runApplication<CallcenterDemoApplication>(*args)

}
