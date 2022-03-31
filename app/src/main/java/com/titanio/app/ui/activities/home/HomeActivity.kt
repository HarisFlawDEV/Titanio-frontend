package com.titanio.app.ui.activities.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
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


    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(mNavController, null)
    }
}