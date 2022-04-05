package com.titanio.app.ui.activities.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.titanio.app.R
import com.titanio.app.databinding.ActivityHomeBinding
import com.titanio.app.databinding.ActivitySignUpBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var mNavController: NavController
    private lateinit var mBinding: ActivityHomeBinding
    private var mAppBarConfiguration: AppBarConfiguration? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        mBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        initUI()
    }

    fun initUI() {
        mNavController = findNavController(R.id.nav_home_host_fragment)

        setSupportActionBar(mBinding.mainToolbar)
        getSupportActionBar()?.hide()


        mAppBarConfiguration = AppBarConfiguration.Builder(R.id.navigation_home)
            .build()
        mNavController = Navigation.findNavController(this, R.id.nav_home_host_fragment)
        NavigationUI.setupActionBarWithNavController(
            this, mNavController,
            mAppBarConfiguration!!
        )
        NavigationUI.setupActionBarWithNavController(this, mNavController)

        mBinding.includeHome.llChat.setOnClickListener(View.OnClickListener {

            mBinding.includeHome.imgNavHome.setImageResource(R.drawable.ic_menu_home)
            mBinding.includeHome.imgNavSearch.setImageResource(R.drawable.ic_search_menu)
            mBinding.includeHome.imgChat.setImageResource(R.drawable.ic_chat_selected)
            mBinding.includeHome.imgProfile.setImageResource(R.drawable.ic_menu_profile)

            mNavController.navigate(R.id.navigation_chat)
        })
        mBinding.includeHome.llHome.setOnClickListener(View.OnClickListener {

            mBinding.includeHome.imgNavHome.setImageResource(R.drawable.ic_home_selected)
            mBinding.includeHome.imgNavSearch.setImageResource(R.drawable.ic_search_menu)
            mBinding.includeHome.imgChat.setImageResource(R.drawable.ic_menu_chat)
            mBinding.includeHome.imgProfile.setImageResource(R.drawable.ic_menu_profile)
            mNavController.navigate(R.id.navigation_home)
        })
        mBinding.includeHome.llSearch.setOnClickListener(View.OnClickListener {

            mBinding.includeHome.imgNavHome.setImageResource(R.drawable.ic_menu_home)
            mBinding.includeHome.imgNavSearch.setImageResource(R.drawable.ic_search_selected)
            mBinding.includeHome.imgChat.setImageResource(R.drawable.ic_menu_chat)
            mBinding.includeHome.imgProfile.setImageResource(R.drawable.ic_menu_profile)
            mNavController.navigate(R.id.navigation_search)
        })
        mBinding.includeHome.llProfile.setOnClickListener(View.OnClickListener {

            mBinding.includeHome.imgNavHome.setImageResource(R.drawable.ic_menu_home)
            mBinding.includeHome.imgNavSearch.setImageResource(R.drawable.ic_search_menu)
            mBinding.includeHome.imgChat.setImageResource(R.drawable.ic_menu_chat)
            mBinding.includeHome.imgProfile.setImageResource(R.drawable.ic_profile_selected)
            mNavController.navigate(R.id.navigation_profile)
        })
        mBinding.includeHome.imgAddVideoCenter.setOnClickListener(View.OnClickListener {

            mBinding.includeHome.imgNavHome.setImageResource(R.drawable.ic_menu_home)
            mBinding.includeHome.imgNavSearch.setImageResource(R.drawable.ic_search_menu)
            mBinding.includeHome.imgChat.setImageResource(R.drawable.ic_menu_chat)
            mBinding.includeHome.imgProfile.setImageResource(R.drawable.ic_menu_profile)
            mNavController.navigate(R.id.navigation_add_post)
        })

    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(mNavController, null)
    }


    fun hidebottomBar() {
        mBinding.includeHome.rrBottomBar.visibility = View.GONE


    }

    fun showBottmBar() {
        mBinding.includeHome.rrBottomBar.visibility = View.VISIBLE
    }

    fun navigateToProfile() {
        mBinding.includeHome.imgNavHome.setImageResource(R.drawable.ic_menu_home)
        mBinding.includeHome.imgNavSearch.setImageResource(R.drawable.ic_search_menu)
        mBinding.includeHome.imgChat.setImageResource(R.drawable.ic_menu_chat)
        mBinding.includeHome.imgProfile.setImageResource(R.drawable.ic_profile_selected)
        mNavController.navigate(R.id.navigation_profile)


    }

    override fun onBackPressed() {
        super.onBackPressed()

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_home_host_fragment)

        when (NavHostFragment.findNavController(navHostFragment!!).currentDestination?.id) {
            R.id.navigation_home -> {
                showBottmBar()

                mBinding.includeHome.imgNavHome.setImageResource(R.drawable.ic_home_selected)
                mBinding.includeHome.imgNavSearch.setImageResource(R.drawable.ic_search_menu)
                mBinding.includeHome.imgChat.setImageResource(R.drawable.ic_menu_chat)
                mBinding.includeHome.imgProfile.setImageResource(R.drawable.ic_menu_profile)

            }

            R.id.navigation_search -> {
                showBottmBar()

                mBinding.includeHome.imgNavHome.setImageResource(R.drawable.ic_menu_home)
                mBinding.includeHome.imgNavSearch.setImageResource(R.drawable.ic_search_selected)
                mBinding.includeHome.imgChat.setImageResource(R.drawable.ic_menu_chat)
                mBinding.includeHome.imgProfile.setImageResource(R.drawable.ic_menu_profile)

            }
            R.id.navigation_chat -> {
                showBottmBar()

                mBinding.includeHome.imgNavHome.setImageResource(R.drawable.ic_menu_home)
                mBinding.includeHome.imgNavSearch.setImageResource(R.drawable.ic_search_menu)
                mBinding.includeHome.imgChat.setImageResource(R.drawable.ic_chat_selected)
                mBinding.includeHome.imgProfile.setImageResource(R.drawable.ic_menu_profile)

            }
            R.id.navigation_profile -> {
                showBottmBar()


                mBinding.includeHome.imgNavHome.setImageResource(R.drawable.ic_menu_home)
                mBinding.includeHome.imgNavSearch.setImageResource(R.drawable.ic_search_menu)
                mBinding.includeHome.imgChat.setImageResource(R.drawable.ic_menu_chat)
                mBinding.includeHome.imgProfile.setImageResource(R.drawable.ic_profile_selected)

            }

        }
    }

    fun unSelecteAll() {

        mBinding.includeHome.imgNavHome.setImageResource(R.drawable.ic_menu_home)
        mBinding.includeHome.imgNavSearch.setImageResource(R.drawable.ic_search_menu)
        mBinding.includeHome.imgChat.setImageResource(R.drawable.ic_menu_chat)
        mBinding.includeHome.imgProfile.setImageResource(R.drawable.ic_menu_profile)
    }


}