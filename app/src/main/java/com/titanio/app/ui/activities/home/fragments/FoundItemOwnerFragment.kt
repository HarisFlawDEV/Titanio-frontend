package com.titanio.app.ui.activities.home.fragments

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
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.titanio.app.R
import com.titanio.app.databinding.FragmentFoundItemOwnerBinding
import com.titanio.app.model.ItemFound
import com.titanio.app.ui.activities.home.DrawerActivity
import com.titanio.app.ui.activities.home.adapters.FoundItemAdapter
import com.titanio.app.ui.activities.signup.fragments.layouts
import com.yarolegovich.discretescrollview.DSVOrientation
import com.yarolegovich.discretescrollview.DiscreteScrollView
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter
import com.yarolegovich.discretescrollview.transform.ScaleTransformer
import java.util.*

class FoundItemOwnerFragment : Fragment(),
    DiscreteScrollView.OnItemChangedListener<FoundItemAdapter.ViewHolder> {

    var navController: NavController? = null
    private lateinit var mBinding: FragmentFoundItemOwnerBinding

    private var data: List<ItemFound>? = null
    private var infiniteAdapter: InfiniteScrollAdapter<*>? = null

    private var dots: List<ImageView>? = null
    var itemFoundBy = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentFoundItemOwnerBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        initUI()


    }


    fun initUI() {
        if (arguments != null) {
            itemFoundBy = requireArguments().getBoolean("item_found_by")

        }

        if (itemFoundBy) {
            mBinding.tvLabel.visibility = View.VISIBLE
            mBinding.llProfileDesc.visibility = View.VISIBLE

        } else {
            mBinding.tvLabel.visibility = View.GONE
            mBinding.llProfileDesc.visibility = View.GONE

        }

        (activity as DrawerActivity?)?.hidebottomBar()
        data = getData()

        mBinding.itemPicker.setOrientation(DSVOrientation.HORIZONTAL)
        mBinding.itemPicker.addOnItemChangedListener(this)
        infiniteAdapter =
            InfiniteScrollAdapter.wrap<FoundItemAdapter.ViewHolder>(FoundItemAdapter(data))
        mBinding.itemPicker.setAdapter(infiniteAdapter)
        mBinding.itemPicker.setItemTransitionTimeMillis(200)
        mBinding.itemPicker.setItemTransformer(
            ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build()
        )

        addDots()

        onItemChanged(data!!.get(0), 0)


        mBinding.imgBack.setOnClickListener(View.OnClickListener {
            navController?.navigateUp()
        })
    }

    private fun onItemChanged(item: ItemFound, positionInDataSet: Int) {

        selectDot(item, positionInDataSet)

    }

    fun getData(): List<ItemFound>? {
        return Arrays.asList<ItemFound>(
            ItemFound(R.drawable.found_item_two),
            ItemFound(R.drawable.found_item_one),
            ItemFound(R.drawable.found_item_three),


            )
    }


    override fun onCurrentItemChanged(
        viewHolder: FoundItemAdapter.ViewHolder?,
        adapterPosition: Int
    ) {
        val positionInDataSet = infiniteAdapter!!.getRealPosition(adapterPosition)
        onItemChanged(data!![positionInDataSet], positionInDataSet)
    }


    fun addDots() {
        dots = ArrayList()
        for (i in 0 until data!!.size) {
            val dot = ImageView(requireContext())
            dot.setImageDrawable(resources.getDrawable(R.drawable.ic_dot_greys))
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
                R.drawable.ic_dot_red
            )
        )


    }


    fun selectDot(item: ItemFound, idx: Int) {
        val res: Resources = resources
        for (i in 0 until data!!.size) {
            val drawableId: Int =
                if (i == idx) R.drawable.ic_dot_red else R.drawable.ic_dot_greys
            val drawable: Drawable = res.getDrawable(drawableId)
            dots!![i].setImageDrawable(drawable)


        }
    }

}