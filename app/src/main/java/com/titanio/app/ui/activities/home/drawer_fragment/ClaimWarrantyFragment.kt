package com.titanio.app.ui.activities.home.drawer_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.titanio.app.R
import com.titanio.app.databinding.FragmentClaimWarrantyBinding
import com.titanio.app.ui.activities.home.DrawerActivity

class ClaimWarrantyFragment : Fragment() {


    private lateinit var mBinding: FragmentClaimWarrantyBinding
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentClaimWarrantyBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        initUI()

    }

    fun initUI() {
        (activity as DrawerActivity?)?.hidebottomBar()
        mBinding.imgBack.setOnClickListener(View.OnClickListener {
            navController.navigateUp()
        })
        mBinding.btnSendClaim.setOnClickListener(View.OnClickListener {
            showSendClaimAlert()
        })

    }

    private fun showSendClaimAlert() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_claim_received, null)
        val customDialog = AlertDialog.Builder(requireActivity(), R.style.WrapContentDialog)
            .setCancelable(false)
            .setView(dialogView)

            .show()

        val btnOk = dialogView.findViewById<AppCompatButton>(R.id.btnOk)
        btnOk.setOnClickListener {
            customDialog.dismiss()
            navController.navigateUp()
            navController.navigateUp()


        }
    }

}