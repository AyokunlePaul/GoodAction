package com.goodaction.presentation.authentication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.goodaction.base.BaseFragment
import com.goodaction.databinding.FragmentWelcomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>() {

    override fun getRootBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): FragmentWelcomeBinding {
        return FragmentWelcomeBinding.inflate(inflater, parent, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        onBackPressed { requireActivity().finish() }
        with(binding) {
            btnGetStarted.setOnClickListener {
                val direction =
                    WelcomeFragmentDirections.actionFragmentWelcomeToFragmentGettingStarted()
                navigate(direction)
            }
            btnLogin.setOnClickListener {
                val direction = WelcomeFragmentDirections.actionFragmentWelcomeToFragmentSignIn()
                navigate(direction)
            }
        }
    }
}