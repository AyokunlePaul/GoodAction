package com.goodaction.presentation.authentication.password

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.goodaction.base.BaseFragment
import com.goodaction.databinding.FragmentResetPasswordSuccessfulBinding

class ResetPasswordSuccessfulFragment : BaseFragment<FragmentResetPasswordSuccessfulBinding>() {

    override fun getRootBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): FragmentResetPasswordSuccessfulBinding {
        return FragmentResetPasswordSuccessfulBinding.inflate(inflater, parent, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            btnLogin.setOnClickListener {
                val direction =
                    ResetPasswordSuccessfulFragmentDirections.actionFragmentResetPasswordSuccessfulToFragmentSignIn()
                navigate(direction)
            }
        }
    }
}