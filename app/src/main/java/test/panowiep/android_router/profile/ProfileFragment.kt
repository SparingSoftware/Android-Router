package test.panowiep.android_router.profile


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.profile_item.*

import test.panowiep.android_router.R
import test.panowiep.android_router.model.User
import java.lang.ref.WeakReference


//

class ProfileFragment : Fragment(), IProfileView {


    private val presenter: IProfilePresenter by lazy {
        ProfilePresenter(
            WeakReference(this),
            arguments?.getParcelable("user")
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
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.onViewCreated()
    }


    //
    // IProfileView
    //

    override fun setupViews(user: User?) {
        nameTextView.text = user?.name ?: "Anonymous"
    }

    //
    //
    //

    companion object {
        @JvmStatic
        fun newInstance(user: User?) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("user", user)
                }
            }
    }

}
