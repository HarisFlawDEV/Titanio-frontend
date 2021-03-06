package com.titanio.app.ui.activities.home.fragments

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import com.titanio.app.R
import com.titanio.app.databinding.FragmentPostDetailPicBinding
import com.titanio.app.ui.activities.home.DrawerActivity
import com.titanio.app.ui.activities.postdetailvideo.PostDetailVideoActivity
import java.net.URI

class PostDetailPicFragment : Fragment() {

    private lateinit var mBinding: FragmentPostDetailPicBinding
    private lateinit var mnavController: NavController
    var isVideoEnabled = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentPostDetailPicBinding.inflate(inflater, container, false)
        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mnavController = Navigation.findNavController(view)

        initUI()
    }

    private fun initUI() {

        (activity as DrawerActivity?)?.hidebottomBar()

        if (arguments != null) {
            isVideoEnabled = requireArguments().getBoolean("is_video");

            if (isVideoEnabled) {
                mBinding.imgVideo.visibility = View.VISIBLE
                mBinding.tvTitle.text = getString(R.string.title_post_detail)
                mBinding.tvUsername.text = getString(R.string.username_post_detail)
                mBinding.tvTimeAgo.text = getString(R.string.time_ago_post_detail)

                Glide.with(requireActivity())
                    .load(R.drawable.bg_userone_post_details)
                    .into(object : CustomTarget<Drawable?>() {
                        override fun onLoadCleared(@Nullable placeholder: Drawable?) {}
                        override fun onResourceReady(
                            resource: Drawable,
                            transition: Transition<in Drawable?>?
                        ) {
                            mBinding.imgBackgroundPic.background = resource
                        }
                    })


                mBinding.imgUserPic?.let {
                    Glide.with(requireContext())
                        .load(R.drawable.ic_chatseven)
                        .into(it)
                }

            } else {
                mBinding.imgVideo.visibility = View.GONE

                mBinding.tvTitle.text = getString(R.string.title_post_detail_two)
                mBinding.tvUsername.text = getString(R.string.username_post_detail_two)
                mBinding.tvTimeAgo.text = getString(R.string.time_ago_post_detail_two)

                Glide.with(requireActivity())
                    .load(R.drawable.bg_usertwo_post_details)
                    .into(object : CustomTarget<Drawable?>() {
                        override fun onLoadCleared(@Nullable placeholder: Drawable?) {}
                        override fun onResourceReady(
                            resource: Drawable,
                            transition: Transition<in Drawable?>?
                        ) {
                            mBinding.imgBackgroundPic.background = resource
                        }
                    })


                mBinding.imgUserPic?.let {
                    Glide.with(requireContext())
                        .load(R.drawable.ic_chat_user)
                        .into(it)
                }

            }

        }

        mBinding.cvCommentBtn.setOnClickListener(View.OnClickListener {
            mBinding.cvCommentBtn.visibility = View.GONE
            mBinding.cvCommentBar.visibility = View.VISIBLE
        }
        )
        mBinding.imgThreeDots.setOnClickListener(View.OnClickListener {

            if (isVideoEnabled) {
                if (mBinding.llSocialShare.visibility == View.VISIBLE) {
                    mBinding.llSocialShare.visibility = View.GONE

                } else {
                    mBinding.llSocialShare.visibility = View.VISIBLE
                }
            } else {

                if (mBinding.llOptionsPost.visibility == View.VISIBLE) {
                    mBinding.llOptionsPost.visibility = View.GONE

                } else {
                    mBinding.llOptionsPost.visibility = View.VISIBLE
                }
            }


        }
        )

        mBinding.imgBack.setOnClickListener(View.OnClickListener {

            mnavController.navigateUp()
        }
        )

        mBinding.llNoCmt.setOnClickListener(View.OnClickListener {
            mBinding.cvCommentBtn.visibility = View.VISIBLE
            mBinding.cvCommentBar.visibility = View.GONE
        }
        )

        mBinding.imgVideo.setOnClickListener(View.OnClickListener {
            startActivity(Intent(requireActivity(), PostDetailVideoActivity::class.java))
        })
        mBinding.imgLike.setOnClickListener(View.OnClickListener {
            mBinding.imgLike.setImageResource(R.drawable.ic_like_active)
        })
        mBinding.llProfileClick.setOnClickListener(View.OnClickListener {
            mnavController.navigate(R.id.navigation_other_user_profile)
        })
    }

}