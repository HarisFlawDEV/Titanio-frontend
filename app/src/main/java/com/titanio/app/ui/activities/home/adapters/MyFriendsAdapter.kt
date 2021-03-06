package com.titanio.app.ui.activities.home.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.titanio.app.R
import com.titanio.app.model.MyFriendsModel
import io.github.florent37.shapeofview.shapes.BubbleView
import java.util.ArrayList

class MyFriendsAdapter(
    private val context: Context,
    private val myFriendsList: ArrayList<MyFriendsModel>,
) : RecyclerView.Adapter<MyFriendsAdapter.MyViewHolder>() {

    private var myInterface: MyInterface? = null

    interface MyInterface {
        fun onInviteFriendItemClick(position: Int)
        fun onMessageItemClick()
        fun onunfriendItemClick()
        fun onAddInGroupItemClick(position: Int)
    }

    fun setClickListener(myInterface: MyInterface) {
        this.myInterface = myInterface
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var ivFriendImage: ImageView = itemView.findViewById(R.id.ivFriendImage)
        var tvFriendName: TextView = itemView.findViewById(R.id.tvFriendName)
        var ivOptions: ImageView = itemView.findViewById(R.id.ivOptions)
        var llOptions: LinearLayout = itemView.findViewById(R.id.ll_options_menu)
        var ll_message: LinearLayout = itemView.findViewById(R.id.ll_message)
        var ll_unfriend: LinearLayout = itemView.findViewById(R.id.ll_unfriend)
        var llAddInGroupMenu: LinearLayout = itemView.findViewById(R.id.llAddInGroupMenu)

        init {
            llOptions.setOnClickListener(View.OnClickListener {
                myInterface!!.onInviteFriendItemClick(adapterPosition)
            })
            ll_message.setOnClickListener(View.OnClickListener {
                myInterface!!.onMessageItemClick()
            })
            ll_unfriend . setOnClickListener (View.OnClickListener {
                myInterface!!.onunfriendItemClick()
            })

            llAddInGroupMenu. setOnClickListener (View.OnClickListener {
                myInterface!!.onAddInGroupItemClick(adapterPosition)
            })


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_my_friends, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return myFriendsList.size
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = myFriendsList[position]
        val param = holder.itemView.layoutParams as ViewGroup.MarginLayoutParams
        param.setMargins(0, 10, 0, 20)
        holder.itemView.layoutParams =
            param // Tested!! - You need this line for the params to be applied.
        holder.tvFriendName.setText(currentItem.friendName)
        holder.ivFriendImage.setImageResource(currentItem.friendImage)
        holder.ivOptions.setOnClickListener(View.OnClickListener {
            if (holder.llOptions.visibility == View.VISIBLE) {
                holder.llOptions.visibility = View.GONE
            } else {
                holder.llOptions.visibility = View.VISIBLE
            }
        })


    }
}