package ru.vote.ui.auth

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fr_auth.*
import ru.vote.R
import ru.vote.extensions.isValidLogin
import ru.vote.extensions.isValidPass
import ru.vote.ui.message.MessageFragment
import ru.vote.viewmodel.AuthState
import ru.vote.viewmodel.AuthViewModel

class AuthFragment : Fragment() {

    private lateinit var viewModel: AuthViewModel
    private var isValid = false

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View? {
        super.onCreateView(inflater, group, state)
        return inflater.inflate(R.layout.fr_auth, group, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(activity!!)[AuthViewModel::class.java]
        // Корректность данных
        isValid = (editLogin.isValidLogin() && editPassword.isValidPass())
        viewModel.setValidForm(isValid)

        viewModel.observeForm(this, Observer {
            viewModel.setEnableAction(isValid)
        })

        // Чекаем поля при изменении
        listOf(editLogin, editPassword).forEach {

            it.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable?) {}
                override fun beforeTextChanged(s: CharSequence?, t: Int, c: Int, a: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                    if (it == editPassword) editPassword.isValidLogin() else editPassword.isValidPass()

                    isValid = (editPassword.isValidLogin() && editPassword.isValidPass())
                    viewModel.setValidForm(isValid)
                    viewModel.setEnableAction(isValid && (viewModel.getState() == AuthState.SIGN_IN))

                }
            })

        }

        btnLogin.setOnClickListener {
            checkAuth(editLogin.text.toString(), editPassword.text.toString())
        }

    }


    private fun checkAuth(login: String, pass: String) {

        activity!!.supportFragmentManager
            .beginTransaction()
            .addToBackStack("S")
            .replace(R.id.host_activity, MessageFragment(0))
            .commit()


        val handler = Handler()
        handler.postDelayed({
            activity!!.supportFragmentManager
                .beginTransaction()
                .addToBackStack("S")
                .replace(R.id.host_activity, AuthFragment())
                .commit()
        }, 3000)
        // Заглушка
        if (login == "ADMiN" && pass == "pass123") {


        }
    }


}