package com.titanio.app.ui.activities.signup.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.titanio.app.R
import com.titanio.app.databinding.FragmentSuitCaseAddedBinding
import com.titanio.app.databinding.FragmentSuitCaseDetailsBinding

class SuitCaseAddedFragment : Fragment() {


    private lateinit var mBinding: FragmentSuitCaseAddedBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentSuitCaseAddedBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        initUI()
    }

    fun initUI() {

        mBinding.btnAddAnotherLuggage.setOnClickListener(View.OnClickListener {
            navController.navigate(R.id.navigation_scan_qr_code)
        })

    }
}