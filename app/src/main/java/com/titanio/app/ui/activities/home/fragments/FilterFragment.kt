package com.titanio.app.ui.activities.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginTop
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.titanio.app.databinding.FragmentFilterBinding
import com.titanio.app.ui.activities.home.DrawerActivity

class FilterFragment: Fragment() {
    private lateinit var mBinding: FragmentFilterBinding
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentFilterBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        initUI()

    }

    fun initUI() {


        (activity as DrawerActivity?)?.hidebottomBar()


    mBinding.rlFamily.setOnClickListener(View.OnClickListener {
        if (mBinding.llFamilyList.visibility == View.GONE){
            mBinding.llFamilyList.visibility = View.VISIBLE
            mBinding.llFriendsList.visibility = View.GONE
            mBinding.llBusinessTravel.visibility = View.GONE
        }
        else {
            mBinding.llFamilyList.visibility = View.GONE
        }
       })

    mBinding.rlFriends.setOnClickListener(View.OnClickListener {
        if (mBinding.llFriendsList.visibility == View.GONE){
            mBinding.llFriendsList.visibility = View.VISIBLE
            mBinding.llFamilyList.visibility = View.GONE
            mBinding.llBusinessTravel.visibility = View.GONE
        }
        else {
            mBinding.llFriendsList.visibility = View.GONE
        }
    })

    mBinding.rlBusinessTravel.setOnClickListener(View.OnClickListener {
        if (mBinding.llBusinessTravel.visibility == View.GONE){
            mBinding.llBusinessTravel.visibility = View.VISIBLE
            mBinding.llFriendsList.visibility = View.GONE
            mBinding.llFamilyList.visibility = View.GONE
        }
        else {
            mBinding.llBusinessTravel.visibility = View.GONE
        }
    })

        mBinding.imgBack.setOnClickListener(View.OnClickListener {
            navController.navigateUp()
        })

    }


}