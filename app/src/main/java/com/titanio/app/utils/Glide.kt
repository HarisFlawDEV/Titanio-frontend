package com.titanio.app.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.Nullable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

class Glide(ctx: Context,drawableres: Drawable) {

    fun Glider(ctx : Context,drawableres: Drawable){
        Glide.with(ctx)
            .load(drawableres)
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
             //       ctx.setBackground(resource)
                }
            })
    }
}