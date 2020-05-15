package ru.vote.ui.message

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fr_message.*
import ru.vote.R
import ru.vote.ui.message.MessageType.CHECK_VOTE
import ru.vote.ui.message.MessageType.DONE_VOTE
import ru.vote.ui.message.MessageType.NOT_VOTE
import ru.vote.ui.message.MessageType.OK_VOTE
import ru.vote.ui.message.MessageType.PLANE_VOTE
import ru.vote.ui.message.MessageType.TIME_VOTE

class MessageFragment(private val type: Int) : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fr_message, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        titleMessage.text = when (type) {
            CHECK_VOTE -> resources.getText(R.string.check)
            PLANE_VOTE -> resources.getText(R.string.plan_vote)
            else -> "${resources.getText(R.string.welcome)} + User name "

        }

        actionMessage.text = when (type) {
            CHECK_VOTE, OK_VOTE -> resources.getText(R.string.loading)
            TIME_VOTE, NOT_VOTE, DONE_VOTE -> resources.getText(R.string.exit)
            else -> resources.getText(R.string.done)
        }

        actionMessage.isEnabled = when (type) {
            CHECK_VOTE, OK_VOTE -> false
            else -> true
        }


        infoMessage.text = when (type) {
            CHECK_VOTE -> null
            OK_VOTE -> "${resources.getText(R.string.date_meeting)} date \n\n" +
                    "${resources.getText(R.string.start_vote)} start time \n\n" +
                    "${resources.getText(R.string.end_vote)} end time"

            TIME_VOTE -> "${resources.getText(R.string.date_meeting)}date \n\n" +
                    "${resources.getText(R.string.start_vote)}start time \n\n" +
                    "${resources.getText(R.string.end_vote)}end time \n\n" +
                    "${resources.getText(R.string.time_to_start_vote)}time to start"
            NOT_VOTE -> resources.getText(R.string.not_vote)
            DONE_VOTE -> " ${resources.getText(R.string.done_vote)} " +
                    "\n\n ${resources.getText(R.string.status_fail_vote)}"
            else -> "${resources.getText(R.string.date_meeting)} \n\n" +
                    "date meeting"
        }

        infoMessage.visibility = if (type != CHECK_VOTE) View.VISIBLE else View.GONE

        setOrientation()

    }


    private fun setOrientation() {
        if (type in NOT_VOTE..PLANE_VOTE) {

            val params: LinearLayout.LayoutParams =
                infoMessage.layoutParams as LinearLayout.LayoutParams
            params.gravity = Gravity.CENTER_HORIZONTAL
            infoMessage.layoutParams = params
            infoMessage.textAlignment = View.TEXT_ALIGNMENT_CENTER
        }
    }


}