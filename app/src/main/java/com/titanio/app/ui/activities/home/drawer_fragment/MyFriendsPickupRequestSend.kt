package com.titanio.app.ui.activities.home.drawer_fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.titanio.app.databinding.FragmentMyFriendsRequestSendBinding
import com.titanio.app.databinding.FragmentProfileCompletedBinding
import com.titanio.app.ui.activities.home.DrawerActivity

class MyFriendsPickupRequestSend : Fragment() {


    private lateinit var mBinding: FragmentMyFriendsRequestSendBinding
    private lateinit var mnavController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentMyFriendsRequestSendBinding.inflate(inflater, container, false)
        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mnavController = Navigation.findNavController(view)

        initUI()
    }

    fun initUI() {

        (activity as DrawerActivity?)?.hidebottomBar()
        mBinding.btnOk.setOnClickListener(View.OnClickListener {
            mnavController.navigateUp()
            mnavController.navigateUp()
        })

    }
}