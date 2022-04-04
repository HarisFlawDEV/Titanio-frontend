package com.titanio.app.ui.activities.home.adapters

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
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




        Glide.with(ctx)
            .load(item.image)
            .into(object : CustomTarget<Drawable?>() {
//                @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
//                fun onResourceReady(
//                    @NonNull resource: Drawable?,
//                    @Nullable transition: Transition<in Drawable?>?
//                ) {
//                    img_background_pic.setBackground(resource)
//                }

                override fun onLoadCleared(@Nullable placeholder: Drawable?) {}
                override fun onResourceReady(
                    resource: Drawable,
                    transition: Transition<in Drawable?>?
                ) {
                    holder.img_background_pic.setBackground(resource)
                }
            })


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
        holder.ll_profile.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {

                if (holder.adapterPosition >= 0) {

                    iPostClick.profileClick()


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
        var img_background_pic: RelativeLayout
        var img_video: ImageView
        var ll_profile: LinearLayout

        init {


            tv_title = itemView.findViewById(R.id.tv_title)
            img_user_pic = itemView.findViewById(R.id.img_user_pic)
            tv_username = itemView.findViewById(R.id.tv_username)
            tv_time_ago = itemView.findViewById(R.id.tv_time_ago)
            img_background_pic = itemView.findViewById(R.id.img_background_pic)
            img_video = itemView.findViewById(R.id.img_video)
            ll_profile = itemView.findViewById(R.id.ll_profile)

            img_like = itemView.findViewById(R.id.img_like)

        }

    }

    interface IPostClick {
        fun likeClick(index: Int)
        fun profileClick()
    }
}