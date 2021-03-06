package com.titanio.app.ui.activities.home.drawer_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.titanio.app.R
import com.titanio.app.databinding.FragmentMyFlightsBinding
import com.titanio.app.ui.activities.home.DrawerActivity

class MyFlightsFragment : Fragment() {
    private lateinit var mBinding: FragmentMyFlightsBinding
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentMyFlightsBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        initUI()

    }

    fun initUI() {
        (activity as DrawerActivity?)?.hidebottomBar()

        mBinding.imgBack.setOnClickListener {
            navController.navigateUp()
        }

        mBinding.btnPickup.setOnClickListener{
            navController.navigate(R.id.nav_my_friends_pickup)
        }

        mBinding.btnReAssignPickup.setOnClickListener{
            navController.navigate(R.id.nav_my_friends_pickup)
        }

        mBinding.btnReAssignPickupFlight3.setOnClickListener{
            navController.navigate(R.id.nav_my_friends_pickup)
        }

        mBinding.btnTracker.setOnClickListener{
            val bundle = Bundle()
            bundle.putBoolean("is_from_flights",true)
            navController.navigate(R.id.nav_pickup_friend,bundle)
        }
    }
}