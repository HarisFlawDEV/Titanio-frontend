package com.titanio.app.ui.activities.signup.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.titanio.app.R
import com.titanio.app.databinding.FragmentFriendsInGroupBinding
import com.titanio.app.databinding.FragmentProfileCompletedBinding
import com.titanio.app.ui.activities.home.DrawerActivity
import com.titanio.app.ui.activities.home.HomeActivity

class ProfileCompletedFragment : Fragment() {


    private lateinit var mBinding: FragmentProfileCompletedBinding
    private lateinit var mnavController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentProfileCompletedBinding.inflate(inflater, container, false)
        return mBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mnavController = Navigation.findNavController(view)

        initUI()
    }

    fun initUI() {

        mBinding.btnGoToHome.setOnClickListener(View.OnClickListener {
            startActivity(Intent( requireActivity(), DrawerActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))
            requireActivity().finish()
        })

    }
}