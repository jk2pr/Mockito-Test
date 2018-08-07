package com.hoppers.tdd.mvp

import com.hoppers.tdd_mvp.R

class Presenter(val view: LoginView, service: LoginService) {

    fun onLoginClick() {
        if (view.getUserName().isBlank())
            view.showUserNameError(R.string.showUserNameError)
        if (view.getPassword().isBlank())
            view.showPasswordError(R.string.showPasswordError)
    }

}
