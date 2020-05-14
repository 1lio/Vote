package ru.vote.extensions

import android.widget.EditText
import ru.vote.R

fun EditText.isValidLogin(): Boolean {
    return when {
        this.text.toString().isEmpty() -> {
            this.error = resources.getString(R.string.is_not_empty)
            false
        }


        else -> {
            this.error = null
            true
        }
    }

}

fun EditText.isValidPass(): Boolean {
    return when {
        this.text.toString().isEmpty() -> {
            this.error = resources.getString(R.string.is_not_empty)
            false
        }

        this.text.toString().length < 6 -> {
            this.error = resources.getString(R.string.error_min_length_pass)
            false
        }

        else -> {
            this.error = null
            true
        }
    }
}