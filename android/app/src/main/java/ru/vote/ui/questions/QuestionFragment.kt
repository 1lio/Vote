package ru.vote.ui.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.item_template.*
import ru.vote.R

class QuestionFragment : Fragment() {

    private lateinit var viewModel: QuestionViewModel

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View? {
        super.onCreateView(inflater, group, state)
        viewModel = ViewModelProvider(activity!!)[QuestionViewModel::class.java]
        return inflater.inflate(R.layout.item_template, group, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.observeCounter(viewLifecycleOwner, Observer {
            val question = viewModel.getListQuestion()[it - 1]
            voteTitle.text = question.title
            voteSubtitle.text = question.question
            voteCounter.text = "$it/${viewModel.getListQuestion().size}"
            setQuestion(1)
        })

        buttonNext.setOnClickListener { viewModel.incrementCount() }

    }

    private fun setQuestion(type: Int) {
        val presentation = when (type) {
            1 -> viewCheckbox()
            else -> viewRadioButton()
        }
        containerQuestions.addView(presentation)
    }

    private fun viewCheckbox(): View {

        val listBox = mutableListOf<CheckBox>()

        val list = viewModel.getListQuestion()[viewModel.getCount()-1].answeres

        for ((index, value) in list.withIndex()) {

            val checkBox = CheckBox(context)
            checkBox.text = value

            listBox.add(index, checkBox)
        }

        val layout = LinearLayout(context)
        layout.orientation = LinearLayout.VERTICAL

        listBox.forEach { layout.addView(it) }

        return layout

    }


    private fun viewRadioButton(): View = View(context)


}