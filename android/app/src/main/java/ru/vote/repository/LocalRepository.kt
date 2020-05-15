package ru.vote.repository

import com.orhanobut.hawk.Hawk

class LocalRepository {

    companion object {
        fun getInstance() = LocalRepository()
        private const val KEY_CHECK = "check"
        private const val DEF_CHECK = false

        private const val KEY_LOGIN = "login"
        private const val DEF_LOGIN = ""
    }

    // Проверка
    var isSavedLogin: Boolean
        set(value) {
            Hawk.put(KEY_CHECK, value)
        }
        get() = Hawk.get(KEY_CHECK, DEF_CHECK)

    // Логин
    var login: String
        set(value) {
            Hawk.put(KEY_LOGIN, value)
        }
        get() = Hawk.get(KEY_LOGIN, DEF_LOGIN)
}