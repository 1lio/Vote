package ru.vote.ui.questions

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.vote.R
import ru.vote.entity.Question

class QuestionPagerAdapter(private val list: ArrayList<Question>) :
    RecyclerView.Adapter<QuestionPagerAdapter.ViewHolderFragment>() {

    private lateinit var ctx: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderFragment {
        ctx = parent.context
        val v = LayoutInflater.from(ctx).inflate(R.layout.item_template,parent,false)
        return ViewHolderFragment(v)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: ViewHolderFragment, position: Int) {
        holder.bind(position)
    }

    inner class ViewHolderFragment(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener{
        private val voteTitle: TextView = v.findViewById(R.id.voteTitle)
        private val voteSubtitle: TextView = v.findViewById(R.id.voteSubtitle)
        private val voteCounter: TextView = v.findViewById(R.id.voteCounter)
        private val buttonNext: Button = v.findViewById(R.id.buttonNext)

        fun bind(index: Int){
            voteTitle.text = list[index].title
            voteSubtitle.text = list[index].question
            voteCounter.text = "${(index + 1)}"
            itemView.setOnClickListener{this}
        }

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    }

}