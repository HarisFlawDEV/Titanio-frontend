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

class FriendRequestsAdapter(
    private val context: Context,
    private val myFriendsList: ArrayList<MyFriendsModel>,
) : RecyclerView.Adapter<FriendRequestsAdapter.MyViewHolder>() {
    private var myInterface: MyInterface? = null

    interface MyInterface {
        fun onDeleteFriendRequestClick(position: Int)
        fun onConfirmFriendRequestClick(position: Int)

    }

    fun setClickListener(myInterface: MyInterface) {
        this.myInterface = myInterface
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var ivFriendImage: ImageView = itemView.findViewById(R.id.ivFriendImage)
        var tvFriendName: TextView = itemView.findViewById(R.id.tvFriendName)
        var tvDelete: TextView = itemView.findViewById(R.id.tvDelete)
        var tvConfirm: TextView = itemView.findViewById(R.id.tvConfirm)

        init {
            tvDelete.setOnClickListener(View.OnClickListener {
//                myInterface!!.onDeleteFriendRequestClick(adapterPosition)
            })
            tvConfirm.setOnClickListener(View.OnClickListener {
//                myInterface!!.onConfirmFriendRequestClick(adapterPosition)
            })


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_friend_request, parent, false)
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


    }
}