package test.panowiep.android_router.profileList


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_profile_list.*

import test.panowiep.android_router.R
import test.panowiep.android_router.model.User
import test.panowiep.android_router.observer.EventObserver
import test.panowiep.android_router.profile.ProfileFragment
import java.lang.ref.WeakReference

//

class ProfileListFragment : Fragment(), IProfileListView {

    private val presenter: IProfileListPresenter by lazy {
        ProfileListPresenter(
            WeakReference(this),
            EventObserver()
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
        return inflater.inflate(R.layout.fragment_profile_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.onViewCreated()
    }



    //
    // IProfileListView
    //
    override fun setupViews() {
        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)

        usersRecyclerView.layoutManager = LinearLayoutManager(context)
        usersRecyclerView.adapter = ProfileListAdapter { pos: Int ->
            presenter.profileClickedAtPos(pos)
        }
        usersRecyclerView.addItemDecoration(divider)
    }

    override fun update(users: Array<User>) {
        (usersRecyclerView.adapter as? ProfileListAdapter)?.setUsers(users)
    }

    //
    //
    //

    companion object {
        @JvmStatic
        fun newInstance() =
            ProfileListFragment()
    }

}
