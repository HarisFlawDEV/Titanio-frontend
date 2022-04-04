package com.titanio.app.ui.activities.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.titanio.app.R
import com.titanio.app.databinding.FragmentProfileBinding
import com.titanio.app.ui.activities.home.HomeActivity

class ProfileFragment : Fragment() {

    var navController: NavController? = null
    private lateinit var mBinding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentProfileBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        initUI()


    }


    fun initUI() {
        (activity as HomeActivity?)?.showBottmBar()

        mBinding.llEditPrfile.setOnClickListener(View.OnClickListener {
            navController?.navigate(R.id.navigation_edit_profile)
        })
    }
}