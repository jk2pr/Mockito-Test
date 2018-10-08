package com.hoppers.mockito.demo

class LoginService {
    fun doLogin(userName: String, password: String, loginCallback: ILoginCallback) {

        if (userName.contentEquals("Jitendra") && password.contentEquals("123456"))
            loginCallback.userAuthSuccess()
        else
            loginCallback.userAuthFail()


    }
}