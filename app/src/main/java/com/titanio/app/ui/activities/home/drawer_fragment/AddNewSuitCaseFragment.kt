package com.titanio.app.ui.activities.home.drawer_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.titanio.app.R
import com.titanio.app.databinding.FragmentAddNewSuitcaesLuggageBinding
import com.titanio.app.ui.activities.home.DrawerActivity

class AddNewSuitCaseFragment : Fragment() {

    private lateinit var mBinding: FragmentAddNewSuitcaesLuggageBinding
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentAddNewSuitcaesLuggageBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        initUI()

    }

    fun initUI() {

        (activity as DrawerActivity?)?.hidebottomBar()

        if (arguments != null) {
            var isFromMyLuggage = requireArguments().getBoolean("is_from_my_luggage")
            if (isFromMyLuggage) {
                mBinding.tvLabel.setText("Validate your\nWarranty")
            } else {
                mBinding.tvLabel.setText(getResources().getString(R.string.validate_your_suitcase_warranty_luggage_recovery_system))

            }

        }


        mBinding.imgScanQrCode.setOnClickListener(View.OnClickListener {
            navController.navigate(R.id.nav_add_new_suitcase_detail)
        })
    }
}