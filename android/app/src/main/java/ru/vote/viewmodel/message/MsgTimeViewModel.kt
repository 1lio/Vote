package ru.vote.viewmodel.message

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class MsgTimeViewModel : ViewModel() {

    private val time = MutableLiveData<String>()
    private val planedTime = MutableLiveData<Date>()

    private val formatDate = SimpleDateFormat("HH:mm:ss", Locale.ENGLISH)

    fun observeRemainsTime(owner: LifecycleOwner, observer: Observer<String>) {
        time.observe(owner, observer)
    }

    fun setPlanedTime(time: String) {
        planedTime.value = formatDate.parse("$time:00")
    }

    fun updateTime() {

        val hh = Calendar.HOUR_OF_DAY
        val mm = Calendar.MINUTE
        val ss = Calendar.SECOND

        val curDate = formatDate.parse("$hh:$mm:$ss")

        val diff = planedTime.value!!.time - curDate!!.time

        time.value = formatDate.format(Date(diff)).toString()

        Log.i("TIME_TEST", ss.toString() ?: "null")
    }

}