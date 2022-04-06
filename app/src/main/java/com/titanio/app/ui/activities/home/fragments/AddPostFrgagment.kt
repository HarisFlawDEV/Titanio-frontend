package com.titanio.app.ui.activities.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.titanio.app.databinding.FragmentAddPostBinding
import com.titanio.app.ui.activities.home.DrawerActivity

class AddPostFrgagment : Fragment() {

    private lateinit var mBinding: FragmentAddPostBinding
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentAddPostBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        initUI()

    }

    fun initUI() {
        (activity as DrawerActivity?)?.hidebottomBar()
        mBinding.imgBack.setOnClickListener(View.OnClickListener {
            navController.navigateUp()
        })
        mBinding.btnPost.setOnClickListener(View.OnClickListener {
            (activity as DrawerActivity?)?.navigateToProfile()

        })
        mBinding.cvWhoCanSee.setOnClickListener(View.OnClickListener {
            if (mBinding.llWhoCanSeeView.visibility == View.VISIBLE) {
                mBinding.llWhoCanSeeView.visibility = View.GONE
            } else {
                mBinding.llWhoCanSeeView.visibility = View.VISIBLE
            }

        })
        mBinding.cvTagFriend.setOnClickListener(View.OnClickListener {
            if (mBinding.llTagFriend.visibility == View.VISIBLE) {
                mBinding.llTagFriend.visibility = View.GONE
            } else {
                mBinding.llTagFriend.visibility = View.VISIBLE
            }

        })
    }
}