package com.farvher.callcenter.callcenterdemo.services

import com.farvher.callcenter.callcenterdemo.domain.CallcenterWorker
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.AsyncResult
import org.springframework.stereotype.Service
import java.util.concurrent.Future

@Service
class DispatcherImpl : Dispatcher {

    @Autowired
    lateinit var callcenterWorkerPool: CallcenterWorkerPool

    @Async
    override fun dispatchCall(callNumber: Number) {
        println("finding worker ...")
        val worker = callcenterWorkerPool.getCallcenterWorker()
        worker?.takeCall();
        if(worker!=null){
            val random = (5000L..10000L).shuffled().last()
            Thread.sleep(random);
            println("End call #${callNumber} by ${worker!!::class.java.simpleName} with ${random} time")
            callcenterWorkerPool.setAvailable(worker)
        }else{
            println("nobody took the call #${callNumber}!!")
        }

    }


}