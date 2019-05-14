package test.panowiep.android_router.login


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_login.*

import test.panowiep.android_router.R
import test.panowiep.android_router.model.User
import java.lang.ref.WeakReference


class LoginFragment : Fragment(), ILoginView {

    private val presenter: ILoginPresenter by lazy {
        LoginPresenter(
            WeakReference(this),
            LoginRouter(WeakReference(this))
        )
    }

    //
    // Lifecycle
    //

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.onViewCreated()

        loginButton.setOnClickListener {
            presenter.loginClicked()
        }

        skipButton.setOnClickListener {
            presenter.skipClicked()
        }
    }


    //
    // ILoginView
    //

}
