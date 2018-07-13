package com.farvher.callcenter.callcenterdemo.domain


/**
 *
 * Callcenter worker inteface
 * @author farith sanmiguel
 * */
interface CallcenterWorker {

    fun takeCall() : Unit

    fun itsBusy() : Boolean

    fun setItsBusy(boolean :Boolean)

}