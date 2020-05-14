package ru.vote.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import ru.vote.repository.AppRepository

class AuthViewModel : ViewModel() {

    val repository = AppRepository()
    val login = MutableLiveData<String>()
    val pass = MutableLiveData<String>()

    // Sign In
    private val emailData = MutableLiveData<String>()    // email
    private val passData = MutableLiveData<String>()     // пароль
    private val isAuthData = MutableLiveData<Boolean>()  // Авторизован ди пользователь

    //SignUp
  //  private val userAuth = AuthData()

    private val state = MutableLiveData<Int>()
    private val lastState = MutableLiveData<Int>()

    private val actionEnabled = MutableLiveData<Boolean>()
    private val actionName = MutableLiveData<String>()


    val isSavedLogin = MutableLiveData<Boolean>()

    fun observeForm(owner: LifecycleOwner, observer: Observer<Boolean>) {

    }

    fun setValidForm(validate: Boolean) {

    }


    fun getState() = state.value


    fun setEnableAction(boolean: Boolean) {
        actionEnabled.value = boolean
    }

    fun observeEnableAction(owner: LifecycleOwner, observer: Observer<Boolean>) {
        actionEnabled.observe(owner, observer)
    }


}