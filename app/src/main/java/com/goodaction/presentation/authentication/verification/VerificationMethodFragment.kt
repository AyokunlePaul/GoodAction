package com.goodaction.presentation.authentication.verification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.goodaction.base.BaseFragment
import com.goodaction.databinding.FragmentVerificationMethodBinding

class VerificationMethodFragment : BaseFragment<FragmentVerificationMethodBinding>() {

    private val verificationMethodFragmentArgs by navArgs<VerificationMethodFragmentArgs>()

    override fun getRootBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): FragmentVerificationMethodBinding {
        return FragmentVerificationMethodBinding.inflate(inflater, parent, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            tvEmail.text = verificationMethodFragmentArgs.email
            tvPhone.text = verificationMethodFragmentArgs.phone
        }
    }
}