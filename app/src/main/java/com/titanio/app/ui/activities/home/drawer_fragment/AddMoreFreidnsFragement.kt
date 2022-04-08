package com.titanio.app.ui.activities.home.drawer_fragment

import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.titanio.app.R
import com.titanio.app.databinding.FragmentAddMoreFriendsBinding

import com.titanio.app.model.InviteFriendsModel
import com.titanio.app.ui.activities.home.DrawerActivity
import com.titanio.app.ui.activities.home.adapters.AddMoreFriendsAdapter

class AddMoreFreidnsFragement : Fragment() ,AddMoreFriendsAdapter.MyInterface{


    private lateinit var mBinding: FragmentAddMoreFriendsBinding
    private lateinit var navController: NavController


    lateinit var addMoreFriendsAdapter: AddMoreFriendsAdapter
    private lateinit var inviteFriendsList: ArrayList<InviteFriendsModel>
    var isAllSelected: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentAddMoreFriendsBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        initUI()

    }

    fun initUI() {
        (activity as DrawerActivity?)?.hidebottomBar()



        inviteFriendsList = ArrayList()
        prepareDataInviteFriends()
        mBinding.rvFriends.layoutManager = LinearLayoutManager(requireContext())
        addMoreFriendsAdapter = AddMoreFriendsAdapter(requireContext(), inviteFriendsList)
        addMoreFriendsAdapter.setClickListener(this)
        mBinding.rvFriends.adapter = addMoreFriendsAdapter


        mBinding.imgBack.setOnClickListener(View.OnClickListener {
            navController.navigateUp()
        })


    }
    private fun prepareDataInviteFriends() {
        var inviteFriendsModel = InviteFriendsModel("Dale Houston", R.drawable.img_friend_1, false)
        inviteFriendsList.add(inviteFriendsModel)

        inviteFriendsModel = InviteFriendsModel("Jessica Joan", R.drawable.img_friend_2, false)
        inviteFriendsList.add(inviteFriendsModel)


        inviteFriendsModel = InviteFriendsModel("Teresa Frey", R.drawable.img_friend_3, false)
        inviteFriendsList.add(inviteFriendsModel)


        inviteFriendsModel = InviteFriendsModel("Joloc Arc", R.drawable.img_friend_4, false)
        inviteFriendsList.add(inviteFriendsModel)


        inviteFriendsModel = InviteFriendsModel("Elivia Eliis", R.drawable.img_friend_5, false)
        inviteFriendsList.add(inviteFriendsModel)


        inviteFriendsModel = InviteFriendsModel("Abigail Ann", R.drawable.img_friend_6, false)
        inviteFriendsList.add(inviteFriendsModel)


        inviteFriendsModel = InviteFriendsModel("Natalie Sophi", R.drawable.img_friend_7, false)
        inviteFriendsList.add(inviteFriendsModel)
    }

    override fun onInviteFriendItemClick(position: Int) {
        if (inviteFriendsList[position].isInviteSent == false) {
            inviteFriendsList[position].isInviteSent = true
        }

        addMoreFriendsAdapter.notifyDataSetChanged()
    }
}