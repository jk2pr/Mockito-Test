package com.hoppers.mockito.demo


import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.timeout
import org.mockito.Mockito.verify
import org.mockito.internal.junit.VerificationCollectorImpl
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.mockito.junit.VerificationCollector
import org.mockito.verification.VerificationMode
import org.mockito.Mockito.`when` as WhenEver
import org.mockito.ArgumentCaptor
import org.mockito.Captor


class PresenterTest {

    @Mock
    private lateinit var service: LoginService
    @Mock
    private lateinit var view: ILoginView

    @Mock
    private lateinit var callback: ILoginCallback


    private var presenter: Presenter? = null

    @Rule
    @JvmField
    var rule: MockitoRule = MockitoJUnit.rule()

    /*@Rule
    @JvmField
    var rule: VerificationCollector = VerificationCollectorImpl.collector()
*/
    @Before
    fun setUP() {
        presenter = Presenter(view, service)

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


    @Test
    fun doSuccessLogin() {
        WhenEver(view.getUserName()).thenReturn("Jitendra")
        WhenEver(view.getPassword()).thenReturn("123456")
        presenter?.onLoginClick()
        service.doLogin(view.getUserName(), view.getPassword(), callback)
        verify(view).doOnSuccess()
    }


    @Test
    fun doFailLogin() {
        WhenEver(view.getUserName()).thenReturn("wrong")
        WhenEver(view.getPassword()).thenReturn("wrong")
        presenter?.onLoginClick()
        service.doLogin(view.getUserName(), view.getPassword(), callback)
        verify(view).doOnFail()
    }
}