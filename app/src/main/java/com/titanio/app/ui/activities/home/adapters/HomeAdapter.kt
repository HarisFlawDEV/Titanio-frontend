package com.titanio.app.ui.activities.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.titanio.app.R
import com.titanio.app.model.HomeModel

class HomeAdapter(var postItems: Array<HomeModel>, var ctx: Context, var iPostClick: IPostClick) :
    RecyclerView.Adapter<HomeAdapter.CategoryVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryVH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_home, parent, false)
        return CategoryVH(v)
    }

    override fun onBindViewHolder(holder: CategoryVH, position: Int) {
        var item = postItems[position]

        if (item.isVideo) {
            holder.img_video.visibility = View.VISIBLE
        } else {
            holder.img_video.visibility = View.GONE

        }

        if (item.isLike) {
            holder.img_like.setImageResource(R.drawable.ic_like_active)
        } else {
            holder.img_like.setImageResource(R.drawable.ic_like)


        }
        holder.tv_title.setText(item.title)
        holder.tv_username.setText(item.userName)
        holder.tv_time_ago.setText(item.timeAgo)


        holder.img_background_pic?.let {
            Glide.with(ctx)
                .load(item.image)
                .into(it)
        }


        holder.img_user_pic?.let {
            Glide.with(ctx)
                .load(item.profilePic)
                .into(it)
        }

        holder.img_like.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {

                if (holder.adapterPosition >= 0) {

                    iPostClick.likeClick(holder.adapterPosition)


                }
            }
        })

    }

    override fun getItemCount(): Int {
        return postItems.size
    }

    inner class CategoryVH(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var img_like: ImageView
        var tv_title: TextView
        var img_user_pic: ImageView
        var tv_username: TextView
        var tv_time_ago: TextView
        var img_background_pic: ImageView
        var img_video: ImageView


        init {


            tv_title = itemView.findViewById(R.id.tv_title)
            img_user_pic = itemView.findViewById(R.id.img_user_pic)
            tv_username = itemView.findViewById(R.id.tv_username)
            tv_time_ago = itemView.findViewById(R.id.tv_time_ago)
            img_background_pic = itemView.findViewById(R.id.img_background_pic)
            img_video = itemView.findViewById(R.id.img_video)

            img_like = itemView.findViewById(R.id.img_like)

        }

    }

    interface IPostClick {
        fun likeClick(index: Int)
    }
}