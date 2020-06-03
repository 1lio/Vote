package ru.vote.ui.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.item_template.*
import ru.vote.R
import ru.vote.entity.Question

class QuestionFragment(private val question: Question, private val position: Int, private val count: Int) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        cont: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, cont, savedInstanceState)
        return inflater.inflate(R.layout.item_template,cont,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        voteTitle.text = question.title
        voteSubtitle.text = question.question
        voteCounter.text = "${position + 1}/$count"
//        setQuestion(question.type)
    }




    fun setQuestion(type: Int){
        when(type){
        }
    }

}