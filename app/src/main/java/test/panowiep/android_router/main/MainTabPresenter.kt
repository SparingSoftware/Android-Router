package test.panowiep.android_router.main;

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.addTo
import test.panowiep.android_router.model.User
import test.panowiep.android_router.observer.EventObserver
import test.panowiep.android_router.observer.RxEvent
import java.lang.ref.WeakReference


class MainTabPresenter(
    private val viewRef: WeakReference<IMainTabView>?,
    private val user: User?,
    private val eventObserver: EventObserver
) : IMainTabPresenter {

    private var disposable: Disposable? = null

    //
    // Helper
    //

    private var view: IMainTabView? = null
        get() = viewRef?.get()

    //
    // Lifecycle
    //

    override fun onViewCreated() {
        view?.setupViews(user)

        bindObservers()
    }

    override fun onDestroyView() {
        if (disposable?.isDisposed == false) {
            disposable?.dispose()
        }
    }

    //
    // Actions
    //

    override fun aboutClicked() {
        view?.showAbout()
    }


    //
    // Privates
    //

    private fun bindObservers() {
        disposable = eventObserver
            .subscribe(RxEvent.ShowProfile::class.java)
            .subscribe { event ->
                view?.showProfile(event.user)
            }
    }

}


//

interface IMainTabPresenter {

    // Lifecycle
    fun onViewCreated()
    fun onDestroyView()

    // Actions
    fun aboutClicked()

}


//

interface IMainTabView {

    fun setupViews(user: User?)

    //

    fun showProfile(user: User?)
    fun showAbout()

}