package com.titanio.app.ui.activities.home.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.titanio.app.R
import com.titanio.app.model.MyFriendsPickupModel
import java.util.ArrayList

class MyFriendsPickupAdapter (
    private val context: Context,
    private val MyFriendsPickupList: ArrayList<MyFriendsPickupModel>, ) :
    RecyclerView.Adapter<MyFriendsPickupAdapter.MyViewHolder>() {

    private var myInterface: MyInterface? = null

    interface MyInterface {
        fun onMyFriendItemClick(position: Int)
    }


    fun setClickListener(myInterface: MyInterface) {
        this.myInterface = myInterface
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var ivFriendImage: ImageView = itemView.findViewById(R.id.ivFriendImage)
        var tvFriendName: TextView = itemView.findViewById(R.id.tvFriendName)

        init {
            itemView.setOnClickListener(View.OnClickListener {
                myInterface!!.onMyFriendItemClick(adapterPosition)
            })
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_my_friends_pickup, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return MyFriendsPickupList.size
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = MyFriendsPickupList[position]
        val param = holder.itemView.layoutParams as ViewGroup.MarginLayoutParams
        param.setMargins(0, 10, 0, 20)
        holder.itemView.layoutParams =
            param // Tested!! - You need this line for the params to be applied.
        holder.tvFriendName.text = currentItem.friendName
        holder.ivFriendImage.setImageResource(currentItem.friendImage)

    }
}