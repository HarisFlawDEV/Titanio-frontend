package com.titanio.app.ui.activities.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.titanio.app.R
import com.titanio.app.model.ChatModel

class ChatAdapter(
    var chatItems: Array<ChatModel>,
    var ctx: Context,
    var iChatOnClick: IChatOnClick
) :
    RecyclerView.Adapter<ChatAdapter.CategoryVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryVH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_chat, parent, false)
        return CategoryVH(v)
    }

    override fun onBindViewHolder(holder: CategoryVH, position: Int) {
        var item = chatItems[position]

        holder.tvName.setText(item.name)
        holder.tvMessage.setText(item.message)
        holder.tvDuration.setText(item.duration)


        if (item.isText) {
            holder.tvMessage.visibility = View.VISIBLE
            holder.ll_photo.visibility = View.GONE
            holder.ll_video.visibility = View.GONE
        }
        if (item.isPhoto) {
            holder.tvMessage.visibility = View.GONE
            holder.ll_photo.visibility = View.VISIBLE
            holder.ll_video.visibility = View.GONE
        }
        if (item.isVideo) {
            holder.tvMessage.visibility = View.GONE
            holder.ll_photo.visibility = View.GONE
            holder.ll_video.visibility = View.VISIBLE
        }

        holder.imgUser?.let {
            Glide.with(ctx)
                .load(item.icon)
                .into(it)
        }

        if (item.tvMessageCount != "") {
            holder.tvMessageCount.setText(item.tvMessageCount)
            holder.tvMessageCount.visibility = View.VISIBLE
        } else {
            holder.tvMessageCount.visibility = View.GONE

        }
//        if (chatItems.size - 1 == position) {
//            holder.viewBar.visibility = View.GONE
//        }

    }

    override fun getItemCount(): Int {
        return chatItems.size
    }

    inner class CategoryVH(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        var tvName: TextView
        var tvMessage: TextView
        var tvDuration: TextView
        var tvMessageCount: TextView
        var imgUser: ImageView
        var llDuration: LinearLayout
        var ll_photo: LinearLayout
        var ll_video: LinearLayout
        var viewBar: View
        var constraintParent: ConstraintLayout

        init {

            tvName = itemView.findViewById(R.id.tvName)
            tvMessage = itemView.findViewById(R.id.tvMessage)
            tvDuration = itemView.findViewById(R.id.tvDuration)
            tvMessageCount = itemView.findViewById(R.id.tvMessageCount)
            imgUser = itemView.findViewById(R.id.imgUser)
            llDuration = itemView.findViewById(R.id.llDuration)
            ll_photo = itemView.findViewById(R.id.ll_photo)
            ll_video = itemView.findViewById(R.id.ll_video)
            viewBar = itemView.findViewById(R.id.viewBar)
            constraintParent = itemView.findViewById(R.id.constraintParent)

        }

        override fun onClick(p0: View?) {
            when (p0?.id) {
                R.id.constraintParent -> {
                    iChatOnClick.chatRoomsOnClick()
                }

            }

        }
    }

    interface IChatOnClick {
        fun chatRoomsOnClick()
    }
}