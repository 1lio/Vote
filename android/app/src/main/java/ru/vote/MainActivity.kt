package ru.vote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.vote.ui.message.MessageFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.host_activity, MessageFragment(4)).commit()
    }
}
