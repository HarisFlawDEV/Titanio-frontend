package com.titanio.app.ui.activities.home.drawer_fragment

import android.graphics.Paint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.titanio.app.R
import com.titanio.app.databinding.FragmentMyFriendsBinding
import com.titanio.app.model.MyFriendsModel
import com.titanio.app.ui.activities.home.adapters.FriendRequestsAdapter
import com.titanio.app.ui.activities.home.adapters.InviteFriendsAdapter
import com.titanio.app.ui.activities.home.adapters.MyFriendsAdapter

class MyFriendsFragment : Fragment(), MyFriendsAdapter.MyInterface/*, FriendRequestsAdapter.MyInterface*/ {
    var navController: NavController? = null

    private lateinit var mBinding: FragmentMyFriendsBinding
    lateinit var adapterMyFriends: MyFriendsAdapter
    lateinit var adapterFriendRequests: FriendRequestsAdapter
    private lateinit var myFriendsList: ArrayList<MyFriendsModel>
    private lateinit var friendRequestList: ArrayList<MyFriendsModel>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentMyFriendsBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        initUI()
    }

    fun initUI() {

        myFriendsList = ArrayList()
        prepareDataMyFriends()
        mBinding.rvMyFriends.layoutManager = LinearLayoutManager(requireContext())
        adapterMyFriends = MyFriendsAdapter(requireContext(), myFriendsList)
        adapterMyFriends.setClickListener(this)
        mBinding.rvMyFriends.adapter = adapterMyFriends


        friendRequestList = ArrayList()
        prepareFriendRequests()
        mBinding.rvFriendRequests.layoutManager = LinearLayoutManager(requireContext())
        adapterFriendRequests = FriendRequestsAdapter(requireContext(), friendRequestList)
//        adapterFriendRequests.setClickListener(this)
        mBinding.rvFriendRequests.adapter = adapterFriendRequests


        mBinding.tvInviteFriends.setPaintFlags(mBinding.tvInviteFriends.getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)

        mBinding.tvTabFriends.setOnClickListener(View.OnClickListener {
            mBinding.tvTabFriends.setBackground(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.drawbale_bg_my_friends_tab_selected
                )
            )
            mBinding.llTabFriendRequests.visibility = View.GONE
            mBinding.llTabFriends.visibility = View.VISIBLE

            mBinding.tvTabFriends.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            mBinding.tvTabFriendRequests.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            mBinding.tvTabFriendRequests.setBackgroundResource(0)
        })

        mBinding.tvTabFriendRequests.setOnClickListener(View.OnClickListener {
            mBinding.tvTabFriendRequests.setBackground(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.drawbale_bg_my_friends_tab_selected
                )
            )
            mBinding.llTabFriendRequests.visibility = View.VISIBLE
            mBinding.llTabFriends.visibility = View.GONE

            mBinding.tvTabFriendRequests.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            mBinding.tvTabFriends.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            mBinding.tvTabFriends.setBackgroundResource(0)
        })


        mBinding.ivBack.setOnClickListener(View.OnClickListener {
            navController?.navigateUp()
        })
    }

    private fun prepareDataMyFriends() {
        var myFriendsModel = MyFriendsModel("Dale Houston", R.drawable.img_friend_1)
        myFriendsList.add(myFriendsModel)

        myFriendsModel = MyFriendsModel("Jessica Joan", R.drawable.img_friend_2)
        myFriendsList.add(myFriendsModel)


        myFriendsModel = MyFriendsModel("Teresa Frey", R.drawable.img_friend_3)
        myFriendsList.add(myFriendsModel)


        myFriendsModel = MyFriendsModel("Joloc Arc", R.drawable.img_friend_4)
        myFriendsList.add(myFriendsModel)


        myFriendsModel = MyFriendsModel("Elivia Eliis", R.drawable.img_friend_5)
        myFriendsList.add(myFriendsModel)


        myFriendsModel = MyFriendsModel("Abigail Ann", R.drawable.img_friend_6)
        myFriendsList.add(myFriendsModel)


        myFriendsModel = MyFriendsModel("Natalie Sophi", R.drawable.img_friend_7)
        myFriendsList.add(myFriendsModel)
    }

    private fun prepareFriendRequests() {
        var myFriendsModel = MyFriendsModel("Dale Houston", R.drawable.img_friend_1)
        friendRequestList.add(myFriendsModel)

        myFriendsModel = MyFriendsModel("Jessica Joan", R.drawable.img_friend_2)
        friendRequestList.add(myFriendsModel)

        myFriendsModel = MyFriendsModel("Teresa Frey", R.drawable.img_friend_3)
        friendRequestList.add(myFriendsModel)

        myFriendsModel = MyFriendsModel("Joloc Arc", R.drawable.img_friend_4)
        friendRequestList.add(myFriendsModel)

        myFriendsModel = MyFriendsModel("Abigail Ann", R.drawable.img_friend_6)
        friendRequestList.add(myFriendsModel)
    }


    override fun onInviteFriendItemClick(position: Int) {

    }

//    override fun onDeleteFriendRequestClick(position: Int) {
//    }

//    override fun onConfirmFriendRequestClick(position: Int) {
//    }

}