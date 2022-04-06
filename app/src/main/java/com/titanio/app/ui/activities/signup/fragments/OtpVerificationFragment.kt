package com.titanio.app.ui.activities.signup.fragments

import android.graphics.Paint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.titanio.app.R
import com.titanio.app.databinding.FragmentOtpVerificationBinding
import com.titanio.app.databinding.FragmentSubscriptionPlanBinding

class OtpVerificationFragment : Fragment() {

    private lateinit var mBinding: FragmentOtpVerificationBinding
    private lateinit var mnavController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentOtpVerificationBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mnavController = Navigation.findNavController(view)
        mBinding.tvResend.setPaintFlags(mBinding.tvResend.getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)

        initUI()
    }

    fun initUI() {
        mBinding.btnVerify.setOnClickListener(View.OnClickListener {
            mnavController.navigate(R.id.navigation_app_setup)
        })
    }
}