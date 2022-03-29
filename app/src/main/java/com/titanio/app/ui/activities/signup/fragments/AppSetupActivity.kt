package com.titanio.app.ui.activities.signup.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.titanio.app.R
import com.titanio.app.databinding.FragmentAppSetupBinding
import com.titanio.app.ui.activities.home.HomeActivity

class AppSetupActivity : Fragment() {

    private lateinit var mBinding: FragmentAppSetupBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentAppSetupBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        initUI()

    }

    fun initUI() {

        mBinding.cardViewFreeUser.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    activity,
                    HomeActivity::class.java
                ).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            )
            activity?.finish()
        })
        mBinding.cardViewSuitcaseWarrenty.setOnClickListener(View.OnClickListener {
            navController.navigate(R.id.navigation_scan_qr_code)
        })
    }
}