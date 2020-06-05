package ru.vote.ui.questions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ru.vote.repository.FakeRepository

class QuestionViewModel : ViewModel() {

    private val listQuestion = FakeRepository().getQuestions()
    private val curQuest = MutableLiveData<Int>()

    init {
        curQuest.value = 1
    }

    fun observeCounter(owner: LifecycleOwner, observer: Observer<Int>) {
        curQuest.observe(owner, observer)
    }

    fun getListQuestion() = listQuestion

    fun incrementCount() {
        if (curQuest.value == listQuestion.size) curQuest.value = listQuestion.size
        else curQuest.value = curQuest.value?.plus(1) ?: 1
    }

    fun getCount() =
        if (curQuest.value!! >= listQuestion.size) listQuestion.size else curQuest.value
}