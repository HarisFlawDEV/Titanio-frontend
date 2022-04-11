package com.titanio.app.ui.activities.home.drawer_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.titanio.app.R
import com.titanio.app.databinding.FragmentPickupFriendBinding
import com.titanio.app.ui.activities.home.DrawerActivity

class PickUpFriendFragment: Fragment() {

    private lateinit var mBinding: FragmentPickupFriendBinding
    private lateinit var navController: NavController



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentPickupFriendBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)


        initUI()

    }

    fun initUI() {
        (activity as DrawerActivity?)?.hidebottomBar()

        if(arguments != null) {
            var isFromFlights = requireArguments().getBoolean("is_from_flights")
            if (isFromFlights) {
               mBinding.imgUser.setImageResource(R.drawable.ic_user_my_flights)
                mBinding.tvName.text = "Dale Houston"
            }
        }
        mBinding.imgBack.setOnClickListener {
            navController.popBackStack()
        }
        mBinding.iconThreeDot.setOnClickListener {
            if (mBinding.llShareOther.visibility == View.VISIBLE) {
                mBinding.llShareOther.visibility = View.GONE
            }else{
                mBinding.llShareOther.visibility = View.VISIBLE

            }
        }
        mBinding.btnMessage.setOnClickListener {
            navController.navigate(R.id.navigation_chat_user)
        }
    }
}