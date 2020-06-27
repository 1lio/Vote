package ru.vote.ui.questions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fr_template.*
import ru.vote.R
import ru.vote.viewmodel.QuestionViewModel

class QuestionsFragment : Fragment() {

    private lateinit var viewModel: QuestionViewModel

    override fun onCreateView(inflater: LayoutInflater, cont: ViewGroup?, state: Bundle?): View? {
        super.onCreateView(inflater, cont, state)
        viewModel = ViewModelProvider(activity!!)[QuestionViewModel::class.java]
        return inflater.inflate(R.layout.fr_template, cont, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = QuestionPagerAdapter(viewModel.getListQuestion())

      //  viewPager2.isUserInputEnabled = false
        viewPager2.adapter = adapter
       // viewPager2.offscreenPageLimit = 1

        viewModel.observeCounter(viewLifecycleOwner, Observer {
            viewPager2.setCurrentItem(it, true)
        })

    }

}
