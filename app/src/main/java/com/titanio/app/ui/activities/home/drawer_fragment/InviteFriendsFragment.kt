package com.titanio.app.ui.activities.home.drawer_fragment

import android.graphics.Paint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.titanio.app.R
import com.titanio.app.databinding.FragmentChatBinding
import com.titanio.app.databinding.FragmentInviteFriendsBinding
import com.titanio.app.model.InviteFriendsModel
import com.titanio.app.ui.activities.home.DrawerActivity
import com.titanio.app.ui.activities.home.adapters.ChatAdapter
import com.titanio.app.ui.activities.home.adapters.InviteFriendsAdapter

class InviteFriendsFragment : Fragment(), InviteFriendsAdapter.MyInterface {

    var navController: NavController? = null

    lateinit var adapterInviteFriends: InviteFriendsAdapter
    private lateinit var mBinding: FragmentInviteFriendsBinding
    private lateinit var inviteFriendsList: ArrayList<InviteFriendsModel>
    var isAllSelected: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentInviteFriendsBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        initUI()


    }


    fun initUI() {
        mBinding.tvSelectAll.setPaintFlags(mBinding.tvSelectAll.getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)

        inviteFriendsList = ArrayList()
        prepareDataInviteFriends()
        mBinding.rvInviteFriends.layoutManager = LinearLayoutManager(requireContext())
        adapterInviteFriends = InviteFriendsAdapter(requireContext(), inviteFriendsList)
        adapterInviteFriends.setClickListener(this)
        mBinding.rvInviteFriends.adapter = adapterInviteFriends

        mBinding.imgNotification.setOnClickListener(View.OnClickListener {
            navController?.navigate(R.id.nav_notifications)
        })
        mBinding.imgHamburger.setOnClickListener(View.OnClickListener {
            (activity as DrawerActivity?)?.openDrawer()
        })

        mBinding.llSelectAll.setOnClickListener(View.OnClickListener {
            if(!isAllSelected) {
                mBinding.ivCheckbox.setImageResource(R.drawable.ic_checkbox_selected)
                isAllSelected = true
            }
            else {
                mBinding.ivCheckbox.setImageResource(R.drawable.ic_checkbox_unselect)
                isAllSelected = false
            }
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

        adapterInviteFriends.notifyDataSetChanged()
    }
}