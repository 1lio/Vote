package ru.vote.ui.questions

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import ru.vote.entity.Question

class QuestionPagerAdapter(private val questions: ArrayList<Question>, fm: FragmentManager) : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val questionsSize = questions.size
    override fun getItem(position: Int) = QuestionFragment(questions[position], position, questionsSize)
    override fun getCount() = questionsSize

}