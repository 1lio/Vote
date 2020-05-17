package ru.vote.ui.auth

import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fr_auth.*
import ru.vote.R
import ru.vote.extensions.isValidLogin
import ru.vote.extensions.isValidPass
import ru.vote.repository.LocalRepository
import ru.vote.ui.message.MessageFragment

class AuthFragment : Fragment() {

    private val localRepository = LocalRepository.getInstance()
    private var isValid = false

    // Подготовительные фействия
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true  // Сохраняем состояние фрагмента, живет до onDestroy
    }

    // Вызывается создание компонентов
    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View? {
        super.onCreateView(inflater, group, state)
        return inflater.inflate(R.layout.fr_auth, group, false)
    }

    // Компаненты фрагмента созданы
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Заргужаем ранее сохраненный логин
        loadLogin()

        // Чекаем поля при изменении
        listOf(editLogin, editPassword).forEach {

            it.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable?) {
                    editLogin.isValidLogin()
                }

                override fun beforeTextChanged(s: CharSequence?, t: Int, c: Int, a: Int) {
                    editLogin.isValidLogin()
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                    //  if (it == editPassword) editPassword.isValidLogin() else editPassword.isValidPass()

                    isValid = (editPassword.isValidLogin() && editPassword.isValidPass())
                    //     viewModel.setValidForm(isValid)
                    //   viewModel.setEnableAction(isValid && (viewModel.getState() == AuthState.SIGN_IN))

                }
            })

        }

        btnLogin.setOnClickListener {
            checkAuth(editLogin.text.toString(), editPassword.text.toString())
        }

        checkboxLogin.setOnCheckedChangeListener { buttonView, isChecked ->
            saveStateLogin(isChecked)
            saveLogin(editLogin.text.toString())
        }
    }

    // Можем обращаться к активити
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    private fun checkAuth(login: String, pass: String) {

        val fm = activity!!.supportFragmentManager
            .beginTransaction()
            .addToBackStack("S")

        val msgFR = MessageFragment(0)


        fm.replace(R.id.host_activity, msgFR).commit()

        val handler = Handler()
        handler.postDelayed({
            activity!!.onBackPressed()
        }, 3000)
        // Заглушка
        if (login == "ADMiN" && pass == "pass123") {

        }
    }

    // Сохраненные данные
    private fun saveStateLogin(state: Boolean) {
        localRepository.isSavedLogin = state
    }

    private fun loadLogin() {
        val isSaved = localRepository.isSavedLogin
        if (isSaved) editLogin.setText(localRepository.login)
        checkboxLogin.isChecked = isSaved
    }

    private fun saveLogin(login: String) {
        localRepository.login = login
    }
}