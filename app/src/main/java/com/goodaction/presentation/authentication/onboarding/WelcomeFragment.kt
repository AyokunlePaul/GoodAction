package com.goodaction.presentation.authentication.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.goodaction.base.BaseFragment
import com.goodaction.databinding.FragmentWelcomeBinding

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
                    WelcomeFragmentDirections.actionFragmentWelcomeFragmentGettingStarted()
                navigate(direction)
            }
        }
    }
}