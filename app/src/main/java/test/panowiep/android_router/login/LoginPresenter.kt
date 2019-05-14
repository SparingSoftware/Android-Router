package test.panowiep.android_router.login

import test.panowiep.android_router.model.User
import java.lang.ref.WeakReference
import android.util.Log;


class LoginPresenter(
    private val viewRef: WeakReference<ILoginView>?
) : ILoginPresenter {

    private var loggedUser = User("Piotr")


    //
    // Helper
    //

    private var view: ILoginView? = null
        get() = viewRef?.get()

    //
    // Lifecycle
    //

    override fun onViewCreated() {
        //
    }


    //
    // Actions
    //

    override fun loginClicked() {
        view?.showMain(loggedUser)
    }

    override fun skipClicked() {
        view?.showMain(null)
    }

}


//

interface ILoginPresenter {

    // Lifecycle
    fun onViewCreated()

    // Actions
    fun loginClicked()
    fun skipClicked()
}


//

interface ILoginView {

    fun showMain(user: User?)

}