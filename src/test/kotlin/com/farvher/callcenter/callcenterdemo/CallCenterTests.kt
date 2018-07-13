package com.farvher.callcenter.callcenterdemo

import com.farvher.callcenter.callcenterdemo.services.Dispatcher
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.scheduling.annotation.EnableAsync
import org.springframework.test.context.junit4.SpringRunner
import java.util.concurrent.Future

@RunWith(SpringRunner::class)
@SpringBootTest
@EnableAsync
class CallCenterTests {

    @Autowired
    lateinit var dispatcher: Dispatcher


    @Test
    fun testTenCalls() {

        for (i in 1..100) {
            println("Incomming call .. #${i}")
            dispatcher.dispatchCall(i);

            Thread.sleep(500);

        }
    }

}
