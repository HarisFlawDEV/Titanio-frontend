package com.titanio.app.ui.activities.home.drawer_fragment

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.titanio.app.R
import com.titanio.app.databinding.FragmentMyPickupBinding
import com.titanio.app.ui.activities.home.DrawerActivity

class MyPickUpFragment : Fragment() {

    private lateinit var mBinding: FragmentMyPickupBinding
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentMyPickupBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        initUI()

    }

    fun initUI() {
        (activity as DrawerActivity?)?.hidebottomBar()

        mBinding.imgBack.setOnClickListener {
            navController.popBackStack()
        }
        mBinding.btnCancel.setOnClickListener {
            showPickUpCancel()
        }
        mBinding.btnViewLocation2.setOnClickListener {
            navController.navigate(R.id.nav_pickup_friend)
        }
    }

    private fun showPickUpCancel() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_pickup_cancel, null)
        val customDialog = AlertDialog.Builder(requireActivity(), R.style.WrapContentDialog)
            .setCancelable(false)
            .setView(dialogView)

            .show()
        customDialog.getWindow()?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val btnNo = dialogView.findViewById<AppCompatButton>(R.id.btn_no)
        val btnYes = dialogView.findViewById<AppCompatButton>(R.id.btn_yes)
        btnNo.setOnClickListener {
            customDialog.dismiss()

        }
        btnYes.setOnClickListener {
            customDialog.dismiss()

        }
    }
}