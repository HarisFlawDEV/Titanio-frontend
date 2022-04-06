package com.titanio.app.ui.activities.home.drawer_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.titanio.app.R
import com.titanio.app.databinding.FragmentLuggageFoundBinding
import com.titanio.app.ui.activities.home.DrawerActivity

class LuggageFounfFragment : Fragment() {

    private lateinit var mBinding: FragmentLuggageFoundBinding
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentLuggageFoundBinding.inflate(inflater, container, false)
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
        mBinding.imgScanQrCode.setOnClickListener(View.OnClickListener {

            navController.navigate(R.id.nav_found_item)
        })
    }
}