package com.hoppers.mockito.demo

class Presenter(val view: ILoginView, service: LoginService) {

    fun onLoginClick() {
        if (view.getUserName().isBlank()) {
            view.showUserNameError(R.string.showUserNameError)
            return
        }
        if (view.getPassword().isBlank()) {
            view.showPasswordError(R.string.showPasswordError)
        }
    }

}
