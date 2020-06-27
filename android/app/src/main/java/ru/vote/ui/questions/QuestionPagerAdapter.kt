package ru.vote.ui.questions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ru.vote.MainActivity
import ru.vote.R
import ru.vote.entity.Question

class QuestionPagerAdapter(private val list: ArrayList<Question>) :
    RecyclerView.Adapter<QuestionPagerAdapter.ViewHolder>() {

    private lateinit var ctx: Context
    private lateinit var viewModel: QuestionViewModel
    private lateinit var listBoxCheckBox: MutableList<CheckBox>
    private lateinit var listBoxRadioButton: MutableList<RadioButton>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        ctx = parent.context
        val activity = ctx as MainActivity
        viewModel = ViewModelProvider(activity)[QuestionViewModel::class.java]
        val v = LayoutInflater.from(ctx).inflate(R.layout.item_template, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        private val voteTitle: TextView = v.findViewById(R.id.voteTitle)
        private val voteSubtitle: TextView = v.findViewById(R.id.voteSubtitle)
        private val voteCounter: TextView = v.findViewById(R.id.voteCounter)
        private val btnNext: Button = v.findViewById(R.id.buttonNext)
        private val containerQuestions: FrameLayout = v.findViewById(R.id.containerQuestions)

        fun bind(index: Int) {
            voteTitle.text = list[index].title
            voteSubtitle.text = list[index].subtitle
            voteCounter.text = "${(index + 1)}/${list.size}"

            btnNext.setOnClickListener{

                viewModel.incrementCount()
            }

            setQuestion(list[index].type)
        }

        private fun setQuestion(type: Int) {
            val presentation = when (type) {
                1 -> viewCheckbox()
                else -> viewRadioButton()
            }
            containerQuestions.addView(presentation)
        }

        private fun viewCheckbox(): View {

            listBoxCheckBox = mutableListOf<CheckBox>()

            val list = viewModel.getListQuestion()[viewModel.getCount()!!].listAnswers

            for ((index, value) in list.withIndex()) {

                val checkBox = CheckBox(ctx)
                checkBox.text = value

                listBox.add(index, checkBox)
            }

            val layout = LinearLayout(ctx)
            layout.orientation = LinearLayout.VERTICAL

            listBox.forEach { layout.addView(it) }

            return layout

        }


        // TODO: Доделать
        private fun viewRadioButton(): View {
            listBoxRadioButton = mutableListOf<RadioButton>()

            val list = viewModel.getListQuestion()[viewModel.getCount()!!].listAnswers

            for ((index, value) in list.withIndex()) {

                val checkBox = RadioButton(ctx)
                checkBox.text = value

                listBox.add(index, checkBox)
            }

            val layout = RadioGroup(ctx)
            layout.invalidate()
            listBox.forEach { layout.addView(it) }
            return layout
        }




    }

}