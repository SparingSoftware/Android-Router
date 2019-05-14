package test.panowiep.android_router.about;

import java.lang.ref.WeakReference


class AboutPresenter(
    private val viewRef: WeakReference<IAboutView>?
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
        view?.exit()
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

    fun exit()

}