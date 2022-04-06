package com.titanio.app.ui.activities.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.titanio.app.R
import com.titanio.app.databinding.FragmentNotificationBinding
import com.titanio.app.databinding.FragmentOtherUserProfileBinding
import com.titanio.app.ui.activities.home.DrawerActivity

class NotificationFragment : Fragment() {

    private lateinit var mBinding: FragmentNotificationBinding
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentNotificationBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        initUI()

    }

    fun initUI() {
        (activity as DrawerActivity?)?.hidebottomBar()

        mBinding.llParentOne.setOnClickListener(View.OnClickListener {

            val bundle = Bundle()
            bundle.putBoolean("item_found_by", true)
            navController.navigate(R.id.navigation_found_item_owner, bundle)
        })
        mBinding.llParentThree.setOnClickListener(View.OnClickListener {
            val bundle = Bundle()
            bundle.putBoolean("item_found_by", false)
            navController.navigate(R.id.navigation_found_item_owner, bundle)

        })
    }
}