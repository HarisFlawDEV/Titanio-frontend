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
import com.titanio.app.databinding.FragmentSignupBinding
import com.titanio.app.ui.activities.login.LoginActivity

class SignupFragment : Fragment() {

    private lateinit var mBinding: FragmentSignupBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentSignupBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        initUI()

    }

    fun initUI() {

        mBinding.tvLogin.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    activity,
                    LoginActivity::class.java
                )
            )
        })

        mBinding.btnSignupScreen.setOnClickListener(View.OnClickListener {

            navController.navigate(R.id.navigation_app_otp)
        })

    }
}