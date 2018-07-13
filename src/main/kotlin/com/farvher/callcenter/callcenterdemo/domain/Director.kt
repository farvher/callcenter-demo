package com.farvher.callcenter.callcenterdemo.domain

import org.slf4j.Logger
import org.slf4j.LoggerFactory

data class Director(var istBusy: Boolean = false) : CallcenterWorker {

    override fun takeCall() {
        println("call taken by a Director")
    }

    override fun itsBusy(): Boolean {
        return istBusy;
    }

    override fun setItsBusy(boolean: Boolean) {
        this.istBusy = boolean;
    }
}