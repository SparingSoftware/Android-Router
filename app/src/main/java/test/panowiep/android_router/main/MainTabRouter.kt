package test.panowiep.android_router.main;


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import test.panowiep.android_router.R
import test.panowiep.android_router.about.AboutActivity
import test.panowiep.android_router.router.Destination
import test.panowiep.android_router.router.FragmentRouter
import test.panowiep.android_router.router.IRouter
import java.lang.ref.WeakReference


//

class MainTabRouterRouter(
    private val viewRef: WeakReference<MainTabFragment>?
) : FragmentRouter<MainTabFragment>(viewRef) {


    //

    override fun navigateTo(destination: Destination) {
        when (destination) {
            is Destination.About ->
                view?.startActivity(Intent(view?.context, AboutActivity::class.java))

            is Destination.Profile -> {
                val navController = view?.findNavController()
                val bundle = Bundle()
                bundle.putParcelable("user", destination.user)
                navController?.navigate(R.id.showProfile, bundle)
            }
        }
    }

    //
    // Helper
    //

    private var view: MainTabFragment? = null
        get() = viewRef?.get()

}