package com.titanio.app.ui.activities.signup.fragments

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.titanio.app.R
import com.titanio.app.databinding.FragmentAppIntroductionBinding


public var layouts: IntArray? = null

class IntrodcutionFragment : Fragment() {

    private var myViewPagerAdapter: MyViewPagerAdapter? = null
    private lateinit var mNavController: NavController

    private lateinit var mBinding: FragmentAppIntroductionBinding


    private var dots: List<ImageView>? = null
    private val NUM_PAGES = 4

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mBinding = FragmentAppIntroductionBinding.inflate(layoutInflater)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mNavController = Navigation.findNavController(view)

        initUI()
    }

    fun initUI() {


        layouts = intArrayOf(
            R.layout.intro_slider_suitcasefor_life,
            R.layout.intro_slider_two_luggae_recovery,
            R.layout.intro_slider_three_live_tracking,
            R.layout.intro_slider_four_save_money
        )

        myViewPagerAdapter = MyViewPagerAdapter(requireContext())
        mBinding.viewPagerIntro.setAdapter(myViewPagerAdapter)


        addDots()
        mBinding.tvStartIntro.setOnClickListener(View.OnClickListener {

            mNavController.navigate(R.id.navigation_subscription_plan)
        })


    }

    fun addDots() {
        dots = ArrayList()
        for (i in 0 until NUM_PAGES) {
            val dot = ImageView(requireContext())
            dot.setImageDrawable(resources.getDrawable(R.drawable.ic_filled_round))
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )

            params.marginStart = 4
            params.marginEnd = 4
            mBinding.layoutDots.addView(dot, params)
            (dots as ArrayList<ImageView>).add(dot)
        }

        dots!!.get(0).setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.ic_filled_rectangle
            )
        )

        mBinding.viewPagerIntro.setOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                selectDot(position)
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }

    fun selectDot(idx: Int) {
        val res: Resources = resources
        for (i in 0 until NUM_PAGES) {
            val drawableId: Int =
                if (i == idx) R.drawable.ic_filled_rectangle else R.drawable.ic_filled_round
            val drawable: Drawable = res.getDrawable(drawableId)
            dots!![i].setImageDrawable(drawable)


            if (idx == 0) {

                mBinding.tvStartIntro.setText(
                    "Skip"
                )
            } else if (idx == layouts!!.size - 1) {
                mBinding.tvStartIntro.setText(
                    "Get Started"
                )
            } else if (idx > 0) {
                mBinding.tvStartIntro.setText(
                    "Skip"
                )
            }
        }
    }

//    /**
//     * View pager adapter
//     */
    class MyViewPagerAdapter(context: Context) : PagerAdapter() {

        private var context: Context? = null

        init {
            this.context = context
        }


        private var layoutInflater: LayoutInflater? = null
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            layoutInflater =
                context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater?
            val view: View = layoutInflater!!.inflate(layouts!!.get(position), container, false)
            container.addView(view)
            return view
        }


        override fun getCount(): Int {
            return layouts!!.size
        }

        override fun isViewFromObject(view: View, obj: Any): Boolean {
            return view === obj
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            val view = `object` as View
            container.removeView(view)
        }
    }
}