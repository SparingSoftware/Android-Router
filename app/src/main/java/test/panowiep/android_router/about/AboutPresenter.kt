package test.panowiep.android_router.about;

import test.panowiep.android_router.router.IRouter
import java.lang.ref.WeakReference


class AboutPresenter(
    private val viewRef: WeakReference<IAboutView>?,
    private val router: IRouter
) : IAboutPresenter {

    //
    // Helper
    //

    private var view: IAboutView? = null
        get() = viewRef?.get()

    //
    // Lifecycle
    //

    override fun onViewCreated() {
        view?.setupViews()
    }


    //
    // Actions
    //

    override fun exitClicked() {
        router?.back()
    }

}


//

interface IAboutPresenter {

    // Lifecycle
    fun onViewCreated()

    // Actions
    fun exitClicked()
}


//

interface IAboutView {

    fun setupViews()

}