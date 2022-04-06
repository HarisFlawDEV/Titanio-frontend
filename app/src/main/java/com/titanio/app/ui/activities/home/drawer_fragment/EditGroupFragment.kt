package com.titanio.app.ui.activities.home.drawer_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.titanio.app.R
import com.titanio.app.databinding.FragmentEditGroupBinding
import com.titanio.app.ui.activities.home.DrawerActivity

class EditGroupFragment : Fragment() {


    private lateinit var mBinding: FragmentEditGroupBinding
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentEditGroupBinding.inflate(inflater, container, false)
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
        mBinding.tvAddMore.setOnClickListener(View.OnClickListener {
            navController.navigate(R.id.navigation_add_more_friends)

        })
        mBinding.btnSave.setOnClickListener(View.OnClickListener {
            navController.navigateUp()
        })
    }
}