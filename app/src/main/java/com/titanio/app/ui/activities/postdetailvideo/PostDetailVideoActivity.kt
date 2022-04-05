package com.titanio.app.ui.activities.postdetailvideo

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.titanio.app.R
import com.titanio.app.databinding.ActivityPostDetailVideoBinding
import com.titanio.app.ui.activities.home.HomeActivity


class PostDetailVideoActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityPostDetailVideoBinding
    private var mAppBarConfiguration: AppBarConfiguration? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        mBinding = ActivityPostDetailVideoBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        initUI()
    }

    fun initUI() {

        mAppBarConfiguration = AppBarConfiguration.Builder(R.id.navigation_home)
            .build()

        mBinding.imgBack.setOnClickListener(View.OnClickListener {

            finish()
        })


        fun FullScreencall() {
            if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
                val v: View = this.window.decorView
                v.setSystemUiVisibility(View.GONE)
            } else if (Build.VERSION.SDK_INT >= 19) {
                //for new api versions.
                val decorView: View = window.decorView
                val uiOptions: Int =
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                decorView.setSystemUiVisibility(uiOptions)
            }
        }
    }
}