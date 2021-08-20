package com.goodaction.presentation.authentication.password

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.goodaction.base.BaseFragment
import com.goodaction.databinding.FragmentResetPasswordBinding

class ResetPasswordFragment : BaseFragment<FragmentResetPasswordBinding>() {

    override fun getRootBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): FragmentResetPasswordBinding {
        return FragmentResetPasswordBinding.inflate(inflater, parent, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            btnComplete.setOnClickListener {
                val direction =
                    ResetPasswordFragmentDirections.actionFragmentResetPasswordToFragmentResetPasswordSuccessful()
                navigate(direction)
            }
        }
    }
}