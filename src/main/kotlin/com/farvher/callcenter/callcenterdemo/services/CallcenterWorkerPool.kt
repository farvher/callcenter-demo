package com.farvher.callcenter.callcenterdemo.services

import com.farvher.callcenter.callcenterdemo.domain.CallcenterWorker

interface CallcenterWorkerPool {

    fun initPool(operator: Long, supervisor: Long, director: Long): Unit

    fun getCallcenterWorker(): CallcenterWorker?

    fun setAvailable(worker : CallcenterWorker) : Unit
}