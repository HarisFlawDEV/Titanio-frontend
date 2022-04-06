package com.titanio.app.ui.activities.home.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.titanio.app.R
import com.titanio.app.model.InviteFriendsModel
import java.util.ArrayList

class AddMoreFriendsAdapter(
    private val context: Context,
    private val inviteFriendsList: ArrayList<InviteFriendsModel>,
) : RecyclerView.Adapter<AddMoreFriendsAdapter.MyViewHolder>() {

    private var myInterface: MyInterface? = null

    interface MyInterface {
        fun onInviteFriendItemClick(position: Int)
    }


    fun setClickListener(myInterface: MyInterface) {
        this.myInterface = myInterface
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var ivFriendImage: ImageView = itemView.findViewById(R.id.ivFriendImage)
        var tvFriendName: TextView = itemView.findViewById(R.id.tvFriendName)
        var tvSendInvite: TextView = itemView.findViewById(R.id.tvSendInvite)

        init {
            itemView.setOnClickListener(View.OnClickListener {
                myInterface!!.onInviteFriendItemClick(adapterPosition)
            })
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_add_more_friends, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return inviteFriendsList.size
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = inviteFriendsList[position]
        val param = holder.itemView.layoutParams as ViewGroup.MarginLayoutParams
        param.setMargins(0, 10, 0, 20)
        holder.itemView.layoutParams =
            param // Tested!! - You need this line for the params to be applied.
        holder.tvFriendName.setText(currentItem.friendName)
        holder.ivFriendImage.setImageResource(currentItem.friendImage)

        if (currentItem.isInviteSent) {
            holder.tvSendInvite.setBackgroundResource(R.color.white)
            holder.tvSendInvite.setText("Request Send")
            holder.tvSendInvite.setTextColor(Color.parseColor("#909090"))
        }


    }
}