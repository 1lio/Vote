package ru.vote

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.vote.ui.auth.AuthFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Запуск стартового фрагмента
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.host_activity, AuthFragment())
                .commitNow()
        }
    }
}
