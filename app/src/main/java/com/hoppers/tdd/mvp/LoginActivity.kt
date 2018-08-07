package com.hoppers.tdd.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hoppers.tdd_mvp.R
import kotlinx.android.synthetic.main.activity_login.*

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity(), LoginView {
    override fun getPassword(): String {
      return  password.text.toString()
    }

    override fun showPasswordError(showError: Int) {
        password.error = getString(showError)
    }

    private val presenter: Presenter by lazy {
        Presenter(this, LoginService())
    }

    override fun getUserName(): String {
        return email.text.toString()
    }

    override fun showUserNameError(showError: Int) {
        email.error = getString(showError)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        email_sign_in_button.setOnClickListener {
            presenter.onLoginClick()
        }
    }
}
