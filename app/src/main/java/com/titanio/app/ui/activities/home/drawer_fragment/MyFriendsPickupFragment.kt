package com.titanio.app.ui.activities.home.drawer_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.titanio.app.R
import com.titanio.app.databinding.FragmentMyFriendsPickupReassignPickupBinding
import com.titanio.app.model.MyFriendsPickupModel
import com.titanio.app.ui.activities.home.DrawerActivity
import com.titanio.app.ui.activities.home.adapters.MyFriendsPickupAdapter

class MyFriendsPickupFragment : Fragment(), MyFriendsPickupAdapter.MyInterface {


    var navController: NavController? = null

    lateinit var adapterMyFriendsPickup : MyFriendsPickupAdapter
    private lateinit var mBinding: FragmentMyFriendsPickupReassignPickupBinding
    private lateinit var MyFriendsPickupList: ArrayList<MyFriendsPickupModel>
    var isAllSelected: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentMyFriendsPickupReassignPickupBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        initUI()
    }

    fun initUI() {
        (activity as DrawerActivity?)?.hidebottomBar()

        MyFriendsPickupList = ArrayList()
        prepareDataMyFriendsList()
        mBinding.rvInviteFriends.layoutManager = LinearLayoutManager(requireContext())
        adapterMyFriendsPickup = MyFriendsPickupAdapter(requireContext(), MyFriendsPickupList)
        adapterMyFriendsPickup.setClickListener(this)
        mBinding.rvInviteFriends.adapter = adapterMyFriendsPickup

        mBinding.ivBack.setOnClickListener(View.OnClickListener {
            navController?.navigateUp()
        })

    }

    private fun prepareDataMyFriendsList() {
        var myFriendsPickupModel = MyFriendsPickupModel("Dale Houston", R.drawable.img_friend_1)
        MyFriendsPickupList.add(myFriendsPickupModel)

        myFriendsPickupModel = MyFriendsPickupModel("Jessica Joan", R.drawable.img_friend_2)
        MyFriendsPickupList.add(myFriendsPickupModel)


        myFriendsPickupModel = MyFriendsPickupModel("Teresa Frey", R.drawable.img_friend_3)
        MyFriendsPickupList.add(myFriendsPickupModel)


        myFriendsPickupModel = MyFriendsPickupModel("Joloc Arc", R.drawable.img_friend_4)
        MyFriendsPickupList.add(myFriendsPickupModel)


        myFriendsPickupModel = MyFriendsPickupModel("Elivia Eliis", R.drawable.img_friend_5)
        MyFriendsPickupList.add(myFriendsPickupModel)


        myFriendsPickupModel = MyFriendsPickupModel("Abigail Ann", R.drawable.img_friend_6)
        MyFriendsPickupList.add(myFriendsPickupModel)


        myFriendsPickupModel = MyFriendsPickupModel("Natalie Sophi", R.drawable.img_friend_7)
        MyFriendsPickupList.add(myFriendsPickupModel)
    }

    override fun onMyFriendItemClick(position: Int) {
        navController?.navigate(R.id.nav_my_friends_pickup_request_send)

    }

}
