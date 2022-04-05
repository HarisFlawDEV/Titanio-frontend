package com.titanio.app.ui.activities.home.drawer_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.titanio.app.R
import com.titanio.app.databinding.FragmentNotificationBinding
import com.titanio.app.databinding.FragmentTimelineDetailBinding
import com.titanio.app.ui.activities.home.HomeActivity

class TimeLineDetailFragment : Fragment() {

    private lateinit var mBinding: FragmentTimelineDetailBinding
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentTimelineDetailBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        initUI()

    }

    fun initUI() {
        (activity as HomeActivity?)?.hidebottomBar()

        mBinding.imgBack.setOnClickListener(View.OnClickListener {
            navController.navigateUp()
        })
        mBinding.imgLike.setOnClickListener(View.OnClickListener {
            mBinding.imgLike.setImageResource(R.drawable.ic_like_active)
        })

        mBinding.imgThreeDots.setOnClickListener(View.OnClickListener {

            if (mBinding.llSocialShare.visibility == View.VISIBLE) {
                mBinding.llSocialShare.visibility = View.GONE

            } else {
                mBinding.llSocialShare.visibility = View.VISIBLE
            }


        }
        )
    }
}