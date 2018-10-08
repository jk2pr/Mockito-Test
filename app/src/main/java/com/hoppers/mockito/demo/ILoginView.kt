package com.hoppers.mockito.demo



    interface ILoginView {
        fun getUserName(): String
        fun showUserNameError(showError: Int)
        fun getPassword(): String
        fun showPasswordError(showError: Int)
        fun doOnSuccess()
        fun doOnFail()
    }


