package ru.vote.ui.questions

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import ru.vote.entity.Question

class QuestionPagerAdapter(private  val list: ArrayList<Question>, fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int) = QuestionFragment()

    override fun getCount() = list.size
}