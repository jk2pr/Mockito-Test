package com.hoppers.tdd.mvp

interface LoginView {
    fun getUserName(): String

    fun showUserNameError(showError: Int)
    fun getPassword(): String
    fun showPasswordError(showError: Int)


}
