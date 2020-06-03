package ru.vote.ui.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fr_template.*
import ru.vote.R
import ru.vote.entity.Question

class QuestionsFragment(private val questions: ArrayList<Question>) : Fragment() {

    private lateinit var adapter: QuestionPagerAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        cont: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, cont, savedInstanceState)
        adapter = QuestionPagerAdapter(questions, childFragmentManager)
        return inflater.inflate(R.layout.fr_template, cont, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager.adapter = adapter


    }
}