package test.panowiep.android_router.profileList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.profile_item.view.*
import test.panowiep.android_router.R
import test.panowiep.android_router.model.User

//

class ProfileListAdapter(
    private val didSelectItem: (pos: Int) -> Unit
): RecyclerView.Adapter<ProfileListAdapter.ViewHolder>() {

    //

    private var users: Array<User> = emptyArray()

    //

    fun setUsers(users: Array<User>) {
        this.users = users
        notifyDataSetChanged()
    }


    //
    //
    //

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.profile_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.nameTextView.text = user.name
        holder.mView.tag = position
        holder.mView.setOnClickListener {
            val pos = it.tag as Int
            didSelectItem(pos)
        }
    }


    //

    inner class ViewHolder(val mView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(mView) {
        val nameTextView: TextView = mView.nameTextView
    }
}