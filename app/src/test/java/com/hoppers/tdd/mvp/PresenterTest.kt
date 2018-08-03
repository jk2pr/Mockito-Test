package com.hoppers.tdd.mvp

import com.hoppers.tdd_mvp.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify


@RunWith(MockitoJUnitRunner::class)
class PresenterTest {


    private val service: LoginService by lazy { Mockito.mock(LoginService::class.java) }
    private val view: LoginView by lazy { Mockito.mock(LoginView::class.java) }
    private var presenter: Presenter? =null


    @Before
    fun setUP() {
        presenter=Presenter(view, service)
    }

    @Test
    fun onLoginClick() {

    }

    @Test
    fun shouldShowErrorMessageWhenUserNameEmpty() {
        `when`(view.getUserName()).thenReturn("")
        presenter?.onLoginClick()
        verify(view.showUserNameError(R.string.showError))


    }
}