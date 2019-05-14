package test.panowiep.android_router.router

import android.app.Activity
import androidx.fragment.app.Fragment
import java.lang.ref.WeakReference


open class FragmentRouter<T: Fragment>(
    private val viewRef: WeakReference<T>?
): IRouter {


    override fun navigateTo(destination: Destination) {
        // to implement
    }

    override fun backTo(destination: Destination) {
        // to implement
    }

    override fun back() {
        // to implement
    }
}


///////


open class ActivityRouter<T: Activity>(
    private val viewRef: WeakReference<T>?
): IRouter {


    override fun navigateTo(destination: Destination) {
        // to implement
    }

    override fun backTo(destination: Destination) {
        // to implement
    }

    override fun back() {
        // to implement
    }
}