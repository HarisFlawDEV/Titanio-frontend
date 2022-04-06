package com.titanio.app.ui.activities.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.titanio.app.R
import com.titanio.app.databinding.FragmentHomeBinding
import com.titanio.app.model.HomeModel
import com.titanio.app.ui.activities.home.DrawerActivity
import com.titanio.app.ui.activities.home.HomeActivity
import com.titanio.app.ui.activities.home.adapters.HomeAdapter

class HomeFragment : Fragment(), HomeAdapter.IPostClick {


    private lateinit var mBinding: FragmentHomeBinding
    private lateinit var navController: NavController


    var postList = arrayOf<HomeModel>(
        HomeModel(
            R.drawable.bg_userone,
            "Spending Holidays With Family",
            R.drawable.ic_user_one,
            "Dale Houston",
            "10 min ago",
            false,
            false
        ),
        HomeModel(
            R.drawable.bg_usertwo,
            "I Did Skydiving For The First Time",
            R.drawable.ic_user_two,
            "Ellis John",
            "1 day ago",
            true,
            false
        ),
        HomeModel(
            R.drawable.bg_userthree,
            "I Did Skydiving For The First Time",
            R.drawable.ic_user_three,
            "Ellis John",
            "1 day ago",
            false,
            false
        ),
        HomeModel(
            R.drawable.bg_userfour,
            "I Did Skydiving For The First Time",
            R.drawable.ic_user_two,
            "Ellis John",
            "1 day ago",
            false,
            false
        ),
    )

    lateinit var homeAdapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        initUI()

    }

    fun initUI() {

        mBinding.rvHome?.setLayoutManager(
            LinearLayoutManager(
                activity,
                LinearLayoutManager.VERTICAL,
                false
            )
        )

        homeAdapter = HomeAdapter(
            postList, requireActivity(), this
        )
        mBinding.rvHome?.adapter = homeAdapter

        mBinding.imgNotification.setOnClickListener(View.OnClickListener {
            navController.navigate(R.id.navigation_notification)
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        (activity as DrawerActivity?)?.showBottmBar()

    }

    override fun likeClick(index: Int) {
        postList.get(index).isLike = true
        mBinding.rvHome.adapter?.notifyDataSetChanged()
    }

    override fun profileClick() {
        navController.navigate(R.id.navigation_other_user_profile)
    }

    override fun parentClick(index: Int) {
        val bundle = Bundle()
        if (index == 1) {
            bundle.putBoolean("is_video", true)
        }
        else{
            bundle.putBoolean("is_video", false)
        }
        navController.navigate(R.id.navigation_post_detail_pic,bundle)
    }
}