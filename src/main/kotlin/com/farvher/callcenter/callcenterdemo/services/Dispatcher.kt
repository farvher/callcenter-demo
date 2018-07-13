package com.farvher.callcenter.callcenterdemo.services

import java.util.concurrent.Future


/**
 *
 * Callcenter dispatcher class
 * @author farith sanmiguel
 * */
open interface Dispatcher {

    fun dispatchCall(callNumber :Number) : Unit;


}