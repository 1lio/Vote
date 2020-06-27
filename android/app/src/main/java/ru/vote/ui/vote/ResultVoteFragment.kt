package ru.vote.ui.vote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.vote.R

// Выводиться приналичии начатого голосования.
// Голосование закончено(по времени или по завершению пользователя)

class ResultVoteFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View? {
        super.onCreateView(inflater, group, state)
        return inflater.inflate(R.layout.fr_result, group, false)
    }


}