package test.panowiep.android_router.profile;

import test.panowiep.android_router.model.User
import java.lang.ref.WeakReference

//

class ProfilePresenter(
    private val viewRef: WeakReference<IProfileView>?,
    private val user: User?
) : IProfilePresenter {

    //
    // Helper
    //

    private var view: IProfileView? = null
        get() = viewRef?.get()

    //
    // Lifecycle
    //

    override fun onViewCreated() {
        view?.setupViews(user)
    }


    //
    // Actions
    //


}


//

interface IProfilePresenter {

    // Lifecycle
    fun onViewCreated()

}


//

interface IProfileView {

    fun setupViews(user: User?)

}