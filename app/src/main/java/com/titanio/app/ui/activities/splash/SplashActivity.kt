package com.titanio.app.ui.activities.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.titanio.app.databinding.ActivitySplashBinding
import com.titanio.app.ui.activities.login.LoginActivity
import com.titanio.app.ui.activities.signup.SignUpActivity

class SplashActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        mBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        initUI()
    }

    fun initUI() {

        mBinding.btnLogin.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
        })

        mBinding.btnSignup.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this@SplashActivity, SignUpActivity::class.java))

        })
    }
}