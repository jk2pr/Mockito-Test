package com.hoppers.mockito.demo


import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.mockito.Mockito.`when` as WhenEver

class PresenterTest {

    @Mock
    private lateinit var service: LoginService
    @Mock
    private lateinit var view: ILoginView

    private var presenter: Presenter? = null

    @Rule
    @JvmField
    var rule: MockitoRule = MockitoJUnit.rule()

    @Before
    fun setUP() {
        presenter = Presenter(view, service)
    }

    @Test
    fun onLoginClick() {

    }

    @Test
    fun shouldShowErrorMessageWhenUserNameEmpty() {
        WhenEver(view.getUserName()).thenReturn("")
     //   WhenEver(view.getPassword()).thenReturn("abcd")
        presenter?.onLoginClick()
        verify(view).showUserNameError(R.string.showUserNameError)


    }

    @Test
    fun shouldShowErrorMessageWhenPasswordEmpty() {
        WhenEver(view.getUserName()).thenReturn("Jitendra")
        WhenEver(view.getPassword()).thenReturn("")
        presenter?.onLoginClick()
        verify(view).showPasswordError(R.string.showPasswordError)


    }
}