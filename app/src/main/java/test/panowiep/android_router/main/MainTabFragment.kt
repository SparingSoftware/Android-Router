package test.panowiep.android_router.main


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.util.Log;
import android.view.*
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.fragment_main_tab.*

import test.panowiep.android_router.R
import test.panowiep.android_router.about.AboutActivity
import test.panowiep.android_router.model.User
import test.panowiep.android_router.observer.EventObserver
import test.panowiep.android_router.profile.ProfileFragment
import test.panowiep.android_router.profileList.ProfileListFragment
import java.lang.ref.WeakReference


class MainTabFragment : Fragment(), IMainTabView {

    private val presenter: IMainTabPresenter by lazy {
        MainTabPresenter(
            WeakReference(this),
            arguments?.getParcelable("user"),
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
        return inflater.inflate(R.layout.fragment_main_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.onViewCreated()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        presenter.onDestroyView()
    }

    //
    // IMainTabView
    //

    override fun setupViews(user: User?) {
        setupPager(user)

        setHasOptionsMenu(true)
    }


    override fun showProfile(user: User?) {
        val navController = findNavController()
        val bundle = Bundle()
        bundle.putParcelable("user", user)
        navController.navigate(R.id.showProfile, bundle)
    }

    override fun showAbout() {
        startActivity(Intent(context, AboutActivity::class.java))
    }

    //
    // Menu
    //

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        // Inflate the menu to use in the action bar
        inflater?.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.aboutButton) {
            presenter.aboutClicked()
            return true
        }

        return false
    }

    //
    // Private
    //

    private fun setupPager(user: User?) {
        val pages = listOf( ProfileListFragment.newInstance(), ProfileFragment.newInstance(user) )
        val pagerAdapter = object: FragmentStatePagerAdapter(childFragmentManager) {
            override fun getItem(position: Int): Fragment {
                return pages[position]
            }

            override fun getCount(): Int {
                return pages.count()
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return listOf("Profile List", "My profile")[position]
            }
        }

        pager.adapter = pagerAdapter
        tablayout.setupWithViewPager(pager)
    }
}
