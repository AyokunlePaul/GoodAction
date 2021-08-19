package com.goodaction.presentation.authentication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.goodaction.base.BaseFragment
import com.goodaction.databinding.FragmentVerificationMethodBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VerificationMethodFragment : BaseFragment<FragmentVerificationMethodBinding>() {

    private val navArg by navArgs<VerificationMethodFragmentArgs>()

    override fun getRootBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): FragmentVerificationMethodBinding {
        return FragmentVerificationMethodBinding.inflate(inflater, parent, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            tvEmail.text = navArg.email
            tvPhone.text = navArg.phone

            cvEmail.setOnClickListener {
                val direction =
                    VerificationMethodFragmentDirections.fragmentVerificationMethodToFragmentCheckEmail(
                        navArg.email
                    )
                navigate(direction)
            }

            cvPhone.setOnClickListener {
                val direction =
                    VerificationMethodFragmentDirections.fragmentVerificationMethodToFragmentOtp(
                        navArg.phone
                    )
                navigate(direction)
            }
        }
    }
}