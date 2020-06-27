package ru.vote.viewmodel

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ru.vote.repository.FakeRepository

class QuestionViewModel : ViewModel() {

    private val listPoll = FakeRepository().getQuestions()
    private val curQuest = MutableLiveData<Int>()
    private val listAnswer = MutableLiveData<MutableMap<Int, String>>()

    init {
        listAnswer.value = mutableMapOf(0 to "")
        curQuest.value = 0
    }



    fun observeCounter(owner: LifecycleOwner, observer: Observer<Int>) {
        curQuest.observe(owner, observer)
    }

    private fun getPollId(): Int {
        return listPoll[curQuest.value ?: 0].id
    }

    fun getListQuestion() = listPoll

    fun incrementCount() {
        if (curQuest.value == listPoll.size) curQuest.value = listPoll.size
        else curQuest.value = curQuest.value?.plus(1) ?: 1
    }

    fun getCount() =
        if (curQuest.value!! >= listPoll.size) listPoll.size else curQuest.value


    @RequiresApi(Build.VERSION_CODES.N)
    fun setAnswer(answers: String) {
        Log.d("MMM", "приходит значение $answers")
        listAnswer.value!![getPollId()] = "$answers"
        Log.d("MMM", "сохраняем значение: ${listAnswer.value.toString()}")
    }

    fun getAnswer(): String = listAnswer.value!![getPollId()] ?: "null"

//    fun isSavedAnswer(index: Int): Boolean {
//        val answers: Array<String>? = listAnswer.value?.get(index)
//        return answers?.get(0)?.isEmpty() ?: false
//    }
}