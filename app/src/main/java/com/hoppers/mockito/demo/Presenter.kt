package com.hoppers.mockito.demo

class Presenter(val view: ILoginView, val service: LoginService)  {



    fun onLoginClick() {
        if (view.getUserName().isBlank()) {
            view.showUserNameError(R.string.showUserNameError)
            return
        }

    }

}
