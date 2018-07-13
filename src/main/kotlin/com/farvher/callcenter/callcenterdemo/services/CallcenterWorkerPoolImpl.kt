package com.farvher.callcenter.callcenterdemo.services

import com.farvher.callcenter.callcenterdemo.domain.CallcenterWorker
import com.farvher.callcenter.callcenterdemo.domain.Director
import com.farvher.callcenter.callcenterdemo.domain.Operator
import com.farvher.callcenter.callcenterdemo.domain.Supervisor
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Component
class CallcenterWorkerPoolImpl : CallcenterWorkerPool {


    private val workers = arrayListOf<CallcenterWorker>()

    private var initialized = false;

    @PostConstruct
    fun init(): Unit {
        initPool(10, 5, 1)
    }


    override fun initPool(operator: Long, supervisor: Long, director: Long): Unit {

        this.initialized = true;

        for (i in 1..operator) {
            workers.add(Operator())
        }
        println("added ${operator} Operators")
        for (i in 1..supervisor) {
            workers.add(Supervisor())
        }
        println("added ${supervisor} supervisors")
        for (i in 1..director) {
            workers.add(Director())
        }
        println("added ${director} directors")

    }

    override fun getCallcenterWorker(): CallcenterWorker? {

        if (!initialized) {
            throw IllegalStateException("must initialize the pool")
        }
        for (i in workers) {
            if (i is Operator && !i.istBusy) {
                println("Operator found :)")
                i.setItsBusy(true);
                return i;
            }
        }
        for (i in workers) {
            if (i is Supervisor && !i.istBusy) {
                println("Supervisor found :)")
                i.setItsBusy(true);
                return i;
            }
        }
        for (i in workers) {
            if (i is Director && !i.istBusy) {
                println("Director found :|")
                i.setItsBusy(true);
                return i;
            }
        }
        println("NO ONE FOUND:(")
        return null
    }

    override fun setAvailable(worker: CallcenterWorker) {
        if (this.workers.contains(worker)) {
            this.workers.filter { it == worker }.single().setItsBusy(false)
        }
    }

}