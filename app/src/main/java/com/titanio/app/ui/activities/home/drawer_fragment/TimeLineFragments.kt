package com.titanio.app.ui.activities.home.drawer_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.titanio.app.R
import com.titanio.app.databinding.FragmentTimeLineBinding
import com.titanio.app.ui.activities.home.DrawerActivity

class TimeLineFragments : Fragment() {


    private lateinit var mBinding: FragmentTimeLineBinding
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentTimeLineBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        initUI()

    }

    fun initUI() {
        (activity as DrawerActivity?)?.hidebottomBar()

        mBinding.imgNotification.setOnClickListener(View.OnClickListener {
            navController.navigate(R.id.nav_notifications)
        })
        mBinding.llParentOne.setOnClickListener(View.OnClickListener {
            navController.navigate(R.id.navigation_time_line_detail)
        })

    }
}