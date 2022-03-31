package com.titanio.app.ui.activities.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.titanio.app.databinding.ActivityLoginBinding
import com.titanio.app.ui.activities.home.HomeActivity
import com.titanio.app.ui.activities.signup.SignUpActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        initUI()
    }

    fun initUI() {
        mBinding.tvSignup.setOnClickListener(View.OnClickListener {

            startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))

        })

        mBinding.btnLoginScreen.setOnClickListener(View.OnClickListener {

            startActivity(Intent(this@LoginActivity, HomeActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK))
//            finish()
        })
    }
}