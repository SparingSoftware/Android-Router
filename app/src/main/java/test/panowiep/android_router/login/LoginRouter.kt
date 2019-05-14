package test.panowiep.android_router.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import test.panowiep.android_router.R
import test.panowiep.android_router.router.Destination
import test.panowiep.android_router.router.FragmentRouter
import test.panowiep.android_router.router.IRouter
import java.lang.ref.WeakReference


//

class LoginRouter(
    private val viewRef: WeakReference<LoginFragment>?
): FragmentRouter<LoginFragment>(viewRef) {


    //

    override fun navigateTo(destination: Destination) {
        when(destination) {
            is Destination.Main -> {
                val navController = view?.findNavController()
                val bundle = Bundle()
                bundle.putParcelable("user", destination.user)
                navController?.navigate(R.id.showMain, bundle)
            }
        }
    }


    //
    // Helper
    //

    private var view: LoginFragment? = null
        get() = viewRef?.get()

}