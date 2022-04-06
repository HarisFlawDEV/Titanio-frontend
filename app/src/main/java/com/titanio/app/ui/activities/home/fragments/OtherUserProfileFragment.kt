package com.titanio.app.ui.activities.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.titanio.app.R
import com.titanio.app.databinding.FragmentOtherUserProfileBinding
import com.titanio.app.ui.activities.home.DrawerActivity

class OtherUserProfileFragment : Fragment() {

    private lateinit var mBinding: FragmentOtherUserProfileBinding
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentOtherUserProfileBinding.inflate(inflater, container, false)
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
        mBinding.imgChatUser.setOnClickListener(View.OnClickListener {
            navController?.navigate(R.id.navigation_chat_user)

        })
    }
}