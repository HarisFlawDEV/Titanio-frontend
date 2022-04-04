package com.titanio.app.ui.activities.home.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.titanio.app.R
import com.titanio.app.databinding.FragmentChatBinding
import com.titanio.app.databinding.FragmentHomeBinding
import com.titanio.app.model.ChatModel
import com.titanio.app.ui.activities.home.HomeActivity
import com.titanio.app.ui.activities.home.adapters.ChatAdapter

class ChatFragment : Fragment(), ChatAdapter.IChatOnClick {


    var messageList = arrayOf<ChatModel>(
        ChatModel(
            R.drawable.ic_chatone,
            "Dale Houston",
            "Neque iuorro quisquam est qui",
            "07 min",
            "1",
            true,
            false,
            false
        ),
        ChatModel(
            R.drawable.ic_chattwo,
            "Teresa Frey",
            "Consectetur, adipisci velit",
            "09 min",
            "2",
            true,
            false,
            false
        ),
        ChatModel(
            R.drawable.ic_chatthree,
            "Jessica Joan",
            "",
            "10 min",
            "",
            false,
            true,
            false
        ),
        ChatModel(
            R.drawable.ic_chatfour,
            "Joloc Arc",
            "Neque porro quisquam est",
            "01 hour",
            "",
            true,
            false,
            false

        ),
        ChatModel(
            R.drawable.ic_chatfive,
            "Ellis John",
            "Consectetur, adipisci velit",
            "Yesterday",
            "",
            true,
            false,
            false
        ),
        ChatModel(
            R.drawable.ic_chatsix,
            "Abigail Ann",
            "",
            "Yesterday",
            "", false,
            false,
            true
        ),

        ChatModel(
            R.drawable.ic_chatseven,
            "Natalie Sophi",
            "Neque porro quisquam est",
            "12/17/21",
            "",
            true,
            false,
            false
        ),
        ChatModel(
            R.drawable.ic_chateight,
            "Ellis John",
            "Consectetur, adipisci velit",
            "12/16/21",
            "",
            true,
            false,
            false
        ),

        );

    var navController: NavController? = null

    lateinit var chatAdapter: ChatAdapter
    private lateinit var mBinding: FragmentChatBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentChatBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        initUI()


    }


    fun initUI() {
        (activity as HomeActivity?)?.showBottmBar()

        mBinding.rvChat?.setLayoutManager(
            LinearLayoutManager(
                activity,
                LinearLayoutManager.VERTICAL,
                false
            )
        )

        chatAdapter = ChatAdapter(
            messageList, requireActivity(), this
        )
        mBinding.rvChat?.adapter = chatAdapter
    }

    override fun chatOnClick() {

        navController?.navigate(R.id.navigation_chat_user)

    }

    override fun userProfileOnClick() {

        navController?.navigate(R.id.navigation_other_user_profile)

    }
}