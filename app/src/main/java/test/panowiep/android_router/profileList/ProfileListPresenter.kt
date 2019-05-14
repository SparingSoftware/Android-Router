package test.panowiep.android_router.profileList;

import android.util.Log
import test.panowiep.android_router.model.User
import test.panowiep.android_router.observer.EventObserver
import test.panowiep.android_router.observer.RxEvent
import java.lang.ref.WeakReference


class ProfileListPresenter(
    private val viewRef: WeakReference<IProfileListView>?,
    private val eventObserver: EventObserver
) : IProfileListPresenter {

    //

    private val users = listOf(
        User("Janek"),
        User("Michal"),
        User("Ania")
    )


    //
    // Helper
    //

    private var view: IProfileListView? = null
        get() = viewRef?.get()

    //
    // Lifecycle
    //

    override fun onViewCreated() {
        view?.setupViews()
        view?.update(users.toTypedArray())
    }


    //
    // Actions
    //

    override fun profileClickedAtPos(pos: Int) {
        val user = users[pos]

        eventObserver.publish(RxEvent.ShowProfile(user))
    }

}


//

interface IProfileListPresenter {

    // Lifecycle
    fun onViewCreated()

    // Actions
    fun profileClickedAtPos(pos: Int)
}


//

interface IProfileListView {

    // Views
    fun setupViews()

    // Data
    fun update(users: Array<User>)


}