package com.titanio.app.ui.activities.home

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.View
import android.view.WindowManager
import android.widget.ExpandableListView.*
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.navigation.NavigationView
import com.titanio.app.R
import com.titanio.app.databinding.ActivityDrawerBinding
import com.titanio.app.ui.activities.home.adapters.ExpandableListItemAdapter
import com.titanio.app.ui.activities.login.LoginActivity

class DrawerActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityDrawerBinding
    private lateinit var mNavController: NavController
    private lateinit var mAppBarConfiguration: AppBarConfiguration

    var expandableListItemAdapter: ExpandableListItemAdapter? = null
    var groupHeaders: ArrayList<String>? = null
    var groupitems: HashMap<String, List<String>>? = null
    var drawables: ArrayList<Drawable>? = null
    var leftChildDrawable: ArrayList<Drawable>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        mBinding = ActivityDrawerBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setSupportActionBar(mBinding.appBarDrawer.mainToolbar)
        getSupportActionBar()?.hide()

        val navView: NavigationView = mBinding.navView
        navView.setItemIconTintList(null)
        mNavController = findNavController(R.id.nav_host_fragment_content_drawer)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = AppBarConfiguration.Builder(
            R.id.nav_home,
            R.id.nav_subscription,
            R.id.nav_my_groups,
            R.id.nav_flight_tracker,
            R.id.nav_pickup_requests,
            R.id.nav_my_pickups,
            R.id.nav_my_flights,
            R.id.nav_shared_flights,
            R.id.nav_my_luggage,
            R.id.nav_my_friends,
            R.id.navigation_time_line,
            R.id.nav_luggage_found,
            R.id.nav_my_profile,
            R.id.nav_our_brands,
            R.id.nav_invite_friends,
            R.id.nav_notifications,
            R.id.nav_report_us,
            R.id.nav_settings,
            R.id.nav_logout
        )
            .setDrawerLayout(mBinding.drawerLayout)
            .build()
        setupActionBarWithNavController(mNavController, mAppBarConfiguration)
        navView.setupWithNavController(mNavController)



        initData()
        expandableListItemAdapter =
            ExpandableListItemAdapter(this, groupHeaders, groupitems, drawables, leftChildDrawable)
        mBinding.expandableListView!!.setAdapter(expandableListItemAdapter)


        mBinding.expandableListView!!.setOnGroupClickListener { parent, v, groupPosition, id ->
            if (groupPosition == 0) {
                mNavController.navigate(R.id.nav_home)
            } else if (groupPosition == 1) {
                mNavController.navigate(R.id.nav_subscription)
            } else if (groupPosition == 2) {
                mNavController.navigate(R.id.nav_my_groups)
            } else if (groupPosition == 4) {
                mNavController.navigate(R.id.nav_my_luggage)
            } else if (groupPosition == 5) {
                mNavController.navigate(R.id.nav_my_friends)
            } else if (groupPosition == 6) {
                mNavController.navigate(R.id.navigation_time_line)
            } else if (groupPosition == 7) {
                mNavController.navigate(R.id.nav_luggage_found)
            } else if (groupPosition == 8) {
                mNavController.navigate(R.id.nav_my_profile)
            } else if (groupPosition == 9) {
                mNavController.navigate(R.id.nav_our_brands)
            } else if (groupPosition == 10) {
                mNavController.navigate(R.id.nav_invite_friends)
            } else if (groupPosition == 11) {
                mNavController.navigate(R.id.nav_notifications)
            } else if (groupPosition == 12) {
                mNavController.navigate(R.id.nav_report_us)
            } else if (groupPosition == 13) {
                mNavController.navigate(R.id.nav_settings)
            } else if (groupPosition == 14) {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
            if (groupPosition != 3) {
                mBinding.drawerLayout?.closeDrawer(Gravity.LEFT)
            }
            false
        }

        mBinding.expandableListView!!.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            if (childPosition == 0) {
                mNavController.navigate(R.id.nav_pickup_requests)
            } else if (childPosition == 1) {
                mNavController.navigate(R.id.nav_my_pickups)
            } else if (childPosition == 2) {
                mNavController.navigate(R.id.nav_my_flights)
            } else if (childPosition == 3) {
                mNavController.navigate(R.id.nav_shared_flights)
            }
            for (g in 0 until expandableListItemAdapter!!.groupCount) {
                mBinding.expandableListView!!.collapseGroup(g)
            }
            mBinding.drawerLayout?.closeDrawer(Gravity.LEFT)
            true
        }

        mBinding.expandableListView!!.setOnGroupExpandListener { groupPosition ->
            for (g in 0 until expandableListItemAdapter!!.groupCount) {
                if (g != groupPosition) {
                    mBinding.expandableListView!!.collapseGroup(g)
                }
            }
        }
        clickListener()
    }

    fun clickListener() {

        mBinding.appBarDrawer.includeHome.llChat.setOnClickListener(View.OnClickListener {

            mBinding.appBarDrawer.includeHome.imgNavHome.setImageResource(R.drawable.ic_menu_home)
            mBinding.appBarDrawer.includeHome.imgNavSearch.setImageResource(R.drawable.ic_search_menu)
            mBinding.appBarDrawer.includeHome.imgChat.setImageResource(R.drawable.ic_chat_selected)
            mBinding.appBarDrawer.includeHome.imgProfile.setImageResource(R.drawable.ic_menu_profile)

            mNavController.navigate(R.id.navigation_chat)
        })
        mBinding.appBarDrawer.includeHome.llHome.setOnClickListener(View.OnClickListener {

            mBinding.appBarDrawer.includeHome.imgNavHome.setImageResource(R.drawable.ic_home_selected)
            mBinding.appBarDrawer.includeHome.imgNavSearch.setImageResource(R.drawable.ic_search_menu)
            mBinding.appBarDrawer.includeHome.imgChat.setImageResource(R.drawable.ic_menu_chat)
            mBinding.appBarDrawer.includeHome.imgProfile.setImageResource(R.drawable.ic_menu_profile)
            mNavController.navigate(R.id.nav_home)
        })
        mBinding.appBarDrawer.includeHome.llSearch.setOnClickListener(View.OnClickListener {

            mBinding.appBarDrawer.includeHome.imgNavHome.setImageResource(R.drawable.ic_menu_home)
            mBinding.appBarDrawer.includeHome.imgNavSearch.setImageResource(R.drawable.ic_search_selected)
            mBinding.appBarDrawer.includeHome.imgChat.setImageResource(R.drawable.ic_menu_chat)
            mBinding.appBarDrawer.includeHome.imgProfile.setImageResource(R.drawable.ic_menu_profile)
            mNavController.navigate(R.id.navigation_search)
        })
        mBinding.appBarDrawer.includeHome.llProfile.setOnClickListener(View.OnClickListener {

            mBinding.appBarDrawer.includeHome.imgNavHome.setImageResource(R.drawable.ic_menu_home)
            mBinding.appBarDrawer.includeHome.imgNavSearch.setImageResource(R.drawable.ic_search_menu)
            mBinding.appBarDrawer.includeHome.imgChat.setImageResource(R.drawable.ic_menu_chat)
            mBinding.appBarDrawer.includeHome.imgProfile.setImageResource(R.drawable.ic_profile_selected)
            mNavController.navigate(R.id.nav_my_profile)
        })

        mBinding.appBarDrawer.includeHome.imgAddVideoCenter.setOnClickListener(View.OnClickListener {

            mBinding.appBarDrawer.includeHome.imgNavHome.setImageResource(R.drawable.ic_menu_home)
            mBinding.appBarDrawer.includeHome.imgNavSearch.setImageResource(R.drawable.ic_search_menu)
            mBinding.appBarDrawer.includeHome.imgChat.setImageResource(R.drawable.ic_menu_chat)
            mBinding.appBarDrawer.includeHome.imgProfile.setImageResource(R.drawable.ic_menu_profile)
            mNavController.navigate(R.id.navigation_add_post)
        })
        val parentView: View = mBinding.navView.getHeaderView(0)
        val ivClose = parentView.findViewById<View>(R.id.ivClose) as ImageView

        ivClose.setOnClickListener(View.OnClickListener {
            mBinding.drawerLayout?.closeDrawer(Gravity.LEFT)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.drawer, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_drawer)
        return navController.navigateUp(mAppBarConfiguration) || super.onSupportNavigateUp()
    }


    fun hidebottomBar() {
        mBinding.appBarDrawer.includeHome.rrBottomBar.visibility = View.GONE

    }

    fun showBottmBar() {
        mBinding.appBarDrawer.includeHome.rrBottomBar.visibility = View.VISIBLE
    }

    fun openDrawer(){
        mBinding.drawerLayout.openDrawer(Gravity.LEFT)
    }


    override fun onBackPressed() {
        super.onBackPressed()

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_drawer)

        when (NavHostFragment.findNavController(navHostFragment!!).currentDestination?.id) {
            R.id.navigation_home -> {
                showBottmBar()

                mBinding.appBarDrawer.includeHome.imgNavHome.setImageResource(R.drawable.ic_home_selected)
                mBinding.appBarDrawer.includeHome.imgNavSearch.setImageResource(R.drawable.ic_search_menu)
                mBinding.appBarDrawer.includeHome.imgChat.setImageResource(R.drawable.ic_menu_chat)
                mBinding.appBarDrawer.includeHome.imgProfile.setImageResource(R.drawable.ic_menu_profile)

            }

            R.id.navigation_search -> {
                showBottmBar()

                mBinding.appBarDrawer.includeHome.imgNavHome.setImageResource(R.drawable.ic_menu_home)
                mBinding.appBarDrawer.includeHome.imgNavSearch.setImageResource(R.drawable.ic_search_selected)
                mBinding.appBarDrawer.includeHome.imgChat.setImageResource(R.drawable.ic_menu_chat)
                mBinding.appBarDrawer.includeHome.imgProfile.setImageResource(R.drawable.ic_menu_profile)

            }
            R.id.navigation_chat -> {
                showBottmBar()

                mBinding.appBarDrawer.includeHome.imgNavHome.setImageResource(R.drawable.ic_menu_home)
                mBinding.appBarDrawer.includeHome.imgNavSearch.setImageResource(R.drawable.ic_search_menu)
                mBinding.appBarDrawer.includeHome.imgChat.setImageResource(R.drawable.ic_chat_selected)
                mBinding.appBarDrawer.includeHome.imgProfile.setImageResource(R.drawable.ic_menu_profile)

            }
            R.id.navigation_profile -> {
                showBottmBar()


                mBinding.appBarDrawer.includeHome.imgNavHome.setImageResource(R.drawable.ic_menu_home)
                mBinding.appBarDrawer.includeHome.imgNavSearch.setImageResource(R.drawable.ic_search_menu)
                mBinding.appBarDrawer.includeHome.imgChat.setImageResource(R.drawable.ic_menu_chat)
                mBinding.appBarDrawer.includeHome.imgProfile.setImageResource(R.drawable.ic_profile_selected)

            }

        }
    }

    fun unSelecteAll() {
        mBinding.appBarDrawer.includeHome.imgNavHome.setImageResource(R.drawable.ic_menu_home)
        mBinding.appBarDrawer.includeHome.imgNavSearch.setImageResource(R.drawable.ic_search_menu)
        mBinding.appBarDrawer.includeHome.imgChat.setImageResource(R.drawable.ic_menu_chat)
        mBinding.appBarDrawer.includeHome.imgProfile.setImageResource(R.drawable.ic_menu_profile)
    }

    private fun initData() {
        groupHeaders = ArrayList()
        groupitems = java.util.HashMap()
        drawables = ArrayList()
        leftChildDrawable = ArrayList()
        groupHeaders!!.add(resources.getString(R.string.menu_home))
        groupHeaders!!.add(resources.getString(R.string.menu_subscription))
        groupHeaders!!.add(resources.getString(R.string.menu_my_groups))
        groupHeaders!!.add(resources.getString(R.string.menu_flight_tracker_pickup))
        val noItems: List<String> = ArrayList()
        val items: MutableList<String> = ArrayList()
        items.add(resources.getString(R.string.menu_pickup_requests))
        items.add(resources.getString(R.string.menu_my_pickups))
        items.add(resources.getString(R.string.menu_my_flights))
        items.add(resources.getString(R.string.menu_shared_flights))

        groupHeaders!!.add(resources.getString(R.string.menu_my_luggage))
        groupHeaders!!.add(resources.getString(R.string.menu_my_friends))
        groupHeaders!!.add(resources.getString(R.string.menu_timeline))
        groupHeaders!!.add(resources.getString(R.string.menu_luggage_found))
        groupHeaders!!.add(resources.getString(R.string.menu_my_profile))
        groupHeaders!!.add(resources.getString(R.string.menu_our_brands))
        groupHeaders!!.add(resources.getString(R.string.menu_invite_friends))
        groupHeaders!!.add(resources.getString(R.string.menu_notifications))
        groupHeaders!!.add(resources.getString(R.string.menu_report_us))
        groupHeaders!!.add(resources.getString(R.string.menu_settings))
        groupHeaders!!.add(resources.getString(R.string.menu_logout))

        groupitems!![groupHeaders!!.get(0)] = noItems
        groupitems!![groupHeaders!!.get(1)] = noItems
        groupitems!![groupHeaders!!.get(2)] = noItems
        groupitems!![groupHeaders!!.get(3)] = items
        groupitems!![groupHeaders!!.get(4)] = noItems
        groupitems!![groupHeaders!!.get(5)] = noItems
        groupitems!![groupHeaders!!.get(6)] = noItems
        groupitems!![groupHeaders!!.get(7)] = noItems
        groupitems!![groupHeaders!!.get(8)] = noItems
        groupitems!![groupHeaders!!.get(9)] = noItems
        groupitems!![groupHeaders!!.get(10)] = noItems
        groupitems!![groupHeaders!!.get(11)] = noItems
        groupitems!![groupHeaders!!.get(12)] = noItems
        groupitems!![groupHeaders!!.get(13)] = noItems
        groupitems!![groupHeaders!!.get(14)] = noItems
        drawables!!.add(resources.getDrawable(R.drawable.ic_drawer_home))
        drawables!!.add(resources.getDrawable(R.drawable.ic_drawer_subscription))
        drawables!!.add(resources.getDrawable(R.drawable.ic_drawer_my_groups))
        drawables!!.add(resources.getDrawable(R.drawable.ic_drawer_flight_tracker))
        drawables!!.add(resources.getDrawable(R.drawable.ic_drawer_my_luggage))
        drawables!!.add(resources.getDrawable(R.drawable.ic_drawer_my_friends))
        drawables!!.add(resources.getDrawable(R.drawable.ic_drawer_timeline))
        drawables!!.add(resources.getDrawable(R.drawable.ic_drawer_luggage_found))
        drawables!!.add(resources.getDrawable(R.drawable.ic_drawer_my_profile))
        drawables!!.add(resources.getDrawable(R.drawable.ic_drawer_brands))
        drawables!!.add(resources.getDrawable(R.drawable.ic_drawer_invite_friends))
        drawables!!.add(resources.getDrawable(R.drawable.ic_drawer_notifications))
        drawables!!.add(resources.getDrawable(R.drawable.ic_drawer_report_us))
        drawables!!.add(resources.getDrawable(R.drawable.ic_drawer_settings))
        drawables!!.add(resources.getDrawable(R.drawable.ic_drawer_logout))
        leftChildDrawable!!.add(resources.getDrawable(R.drawable.drawable_menu_items))
        leftChildDrawable!!.add(resources.getDrawable(R.drawable.drawable_menu_items))
        leftChildDrawable!!.add(resources.getDrawable(R.drawable.drawable_menu_items))
        leftChildDrawable!!.add(resources.getDrawable(R.drawable.drawable_menu_items))
//        KeyboardUtils.addKeyboardToggleListener(this, object : SoftKeyboardToggleListener() {
//            fun onToggleSoftKeyboard(isVisible: Boolean) {
//                if (isVisible) bottomMenuRL.setVisibility(View.GONE) else bottomMenuRL.setVisibility(
//                    View.VISIBLE
//                )
//            }
//        })
    }

    fun navigateToProfile() {
        mBinding.appBarDrawer.includeHome.imgNavHome.setImageResource(R.drawable.ic_menu_home)
        mBinding.appBarDrawer.includeHome.imgNavSearch.setImageResource(R.drawable.ic_search_menu)
        mBinding.appBarDrawer.includeHome.imgChat.setImageResource(R.drawable.ic_menu_chat)
        mBinding.appBarDrawer.includeHome.imgProfile.setImageResource(R.drawable.ic_profile_selected)
        mNavController.navigate(R.id.nav_my_profile)


    }

}