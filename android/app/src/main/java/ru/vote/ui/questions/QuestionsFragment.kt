package ru.vote.ui.questions

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.fr_template.*
import kotlinx.android.synthetic.main.item_template.*
import ru.vote.R

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
        viewPager2.isUserInputEnabled = false
        viewPager2.adapter = adapter
//        viewModel.observeCounter(viewLifecycleOwner, Observer {
//            viewPager.setCurrentItem(it, true)
//        })


        }


    }
}

