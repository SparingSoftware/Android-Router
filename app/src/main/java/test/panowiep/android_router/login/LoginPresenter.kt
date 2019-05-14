package test.panowiep.android_router.login

import test.panowiep.android_router.model.User
import java.lang.ref.WeakReference
import android.util.Log;
import test.panowiep.android_router.router.Destination
import test.panowiep.android_router.router.IRouter


class LoginPresenter(
    private val viewRef: WeakReference<ILoginView>?,
    private val router: IRouter?
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
        router?.navigateTo(Destination.Main(loggedUser))
        // view?.showMain(loggedUser)
    }

    override fun skipClicked() {
        router?.navigateTo(Destination.Main(null))
        // view?.showMain(null)
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

    //

}