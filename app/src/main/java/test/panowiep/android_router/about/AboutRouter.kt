package test.panowiep.android_router.about;


import android.os.Bundle
import android.app.Activity
import test.panowiep.android_router.R
import test.panowiep.android_router.router.ActivityRouter
import test.panowiep.android_router.router.Destination
import test.panowiep.android_router.router.FragmentRouter
import test.panowiep.android_router.router.IRouter
import java.lang.ref.WeakReference


//

class AboutRouter(
    private val viewRef: WeakReference<AboutActivity>?
) : ActivityRouter<AboutActivity>(viewRef) {


    //

    override fun back() {
        view?.finish()
    }

    //
    // Helper
    //

    private var view: AboutActivity? = null
        get() = viewRef?.get()

}