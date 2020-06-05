package ru.vote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.vote.ui.questions.QuestionsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Запуск стартового фрагмента
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_activity, QuestionsFragment())
                .commit()
        }
    }
}
