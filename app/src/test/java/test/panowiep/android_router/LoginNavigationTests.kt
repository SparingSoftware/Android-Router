package test.panowiep.android_router

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.argForWhich
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import test.panowiep.android_router.login.ILoginView
import test.panowiep.android_router.login.LoginPresenter
import test.panowiep.android_router.model.User
import test.panowiep.android_router.router.Destination
import test.panowiep.android_router.router.IRouter
import java.lang.ref.WeakReference

class LoginNavigationTests {

    lateinit var view: ILoginView
    lateinit var router: IRouter

    lateinit var presenter: LoginPresenter

    @Before
    fun setup() {
        view = mock()
        router = mock()

        presenter = LoginPresenter(WeakReference(view), router)
    }


    @Test
    fun test_login() {
        presenter.loginClicked()

        verify(router).navigateTo(Destination.Main(User("Piotr")))
    }

    @Test
    fun test_skip() {
        presenter.skipClicked()

        verify(router).navigateTo(Destination.Main(null))
    }

}