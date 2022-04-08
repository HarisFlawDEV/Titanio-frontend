package com.titanio.app.ui.activities.home.drawer_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.titanio.app.R
import com.titanio.app.databinding.FragmentPickuprequestBinding
import com.titanio.app.ui.activities.home.DrawerActivity

class PickUpRequestFragment: Fragment() {

    private lateinit var mBinding: FragmentPickuprequestBinding
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentPickuprequestBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        initUI()

    }

    fun initUI() {
        (activity as DrawerActivity?)?.hidebottomBar()
        mBinding.btnAccept.setOnClickListener {
            navController.navigate(R.id.nav_my_pickups)
        }
        mBinding.btnAccept2.setOnClickListener {
            navController.navigate(R.id.nav_my_pickups)
        }
        mBinding.btnAccept3.setOnClickListener {
            navController.navigate(R.id.nav_my_pickups)
        }
        mBinding.btnAccept4.setOnClickListener {
            navController.navigate(R.id.nav_my_pickups)
        }
        mBinding.btnAccept5.setOnClickListener {
            navController.navigate(R.id.nav_my_pickups)
        }
        mBinding.btnAccept6.setOnClickListener {
            navController.navigate(R.id.nav_my_pickups)
        }
        mBinding.btnAccept7.setOnClickListener {
            navController.navigate(R.id.nav_my_pickups)
        }
        mBinding.imgBack.setOnClickListener {
            navController.popBackStack()
        }

    }
}