package com.titanio.app.ui.activities.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.titanio.app.databinding.FragmentSearchBinding
import com.titanio.app.ui.activities.home.DrawerActivity

class SearchFragment : Fragment() {

    private lateinit var mBinding: FragmentSearchBinding
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentSearchBinding.inflate(inflater, container, false)
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
            (activity as DrawerActivity?)?.showBottmBar()
            (activity as DrawerActivity?)?.unSelecteAll()


        })
    }
}