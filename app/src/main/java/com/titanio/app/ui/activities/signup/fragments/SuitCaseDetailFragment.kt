package com.titanio.app.ui.activities.signup.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.titanio.app.R
import com.titanio.app.databinding.FragmentSuitCaseDetailsBinding

class SuitCaseDetailFragment : Fragment() {

    private lateinit var mBinding: FragmentSuitCaseDetailsBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentSuitCaseDetailsBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        initUI()
    }

    fun initUI() {

        mBinding.btnConfirmDetail.setOnClickListener(View.OnClickListener {
            navController.navigate(R.id.navigation_suit_case_added)
        })
        mBinding.btnScanAgain.setOnClickListener(View.OnClickListener {
            navController.navigate(R.id.navigation_scan_qr_code)
        })

    }
}