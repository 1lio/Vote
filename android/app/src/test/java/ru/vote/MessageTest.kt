package ru.vote

import org.junit.After
import org.junit.Before
import org.junit.Test
import ru.vote.ui.message.MessageFragment
import java.text.SimpleDateFormat
import java.util.*


class MessageTest {

    private var messageForm: MessageFragment? = null

    @Before
    fun set_up() {
    }

    @Test
    fun test_01() {

        // given:


        // when:


        // then:

        val time = "15:00:00"

        val curTime = Calendar.getInstance().time
        val text = SimpleDateFormat("hh:mm:ss")

        val n = text.format(curTime)


        val h = 60
        val m = h * 60
        val s = 100 * m * h


    }

    @After
    fun tear_down() {

    }
}