package com.titanio.app.ui.activities.signup.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.titanio.app.R
import com.titanio.app.databinding.FragmentAppleTrackingBinding
import com.titanio.app.databinding.FragmentSubscriptionPlanBinding

class AppleTrackingFragment : Fragment() {

    private lateinit var mBinding: FragmentAppleTrackingBinding
    private lateinit var mnavController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentAppleTrackingBinding.inflate(inflater, container, false)
        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mnavController = Navigation.findNavController(view)

        initUI()
    }

    fun initUI() {

        mBinding.btnSkipAppleTracking.setOnClickListener(View.OnClickListener {
            mnavController.navigate(R.id.navigation_Create_Group)
        })

        mBinding.btnNextAppleTracking.setOnClickListener(View.OnClickListener {
            mnavController.navigate(R.id.navigation_Create_Group)
        })

    }
}
