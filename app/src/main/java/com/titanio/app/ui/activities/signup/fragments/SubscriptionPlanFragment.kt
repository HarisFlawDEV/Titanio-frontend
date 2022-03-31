package com.titanio.app.ui.activities.signup.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.titanio.app.R
import com.titanio.app.databinding.FragmentSubscriptionPlanBinding

class SubscriptionPlanFragment : Fragment() {


    private lateinit var mBinding: FragmentSubscriptionPlanBinding
    private lateinit var mnavController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentSubscriptionPlanBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mnavController = Navigation.findNavController(view)

        initUI()
    }

    fun initUI() {
        mBinding.btnSkip.setOnClickListener(View.OnClickListener {
            mnavController.navigate(R.id.navigation_Apple_Tracker)
        })

        mBinding.btnPay.setOnClickListener(View.OnClickListener {
            mnavController.navigate(R.id.navigation_Create_Group)
        }
        )
    }
}