package com.goodaction.presentation.authentication.getstarted

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.goodaction.base.BaseFragment
import com.goodaction.databinding.FragmentGettingStartedBinding

class GettingStartedFragment : BaseFragment<FragmentGettingStartedBinding>() {

    override fun getRootBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): FragmentGettingStartedBinding {
        return FragmentGettingStartedBinding.inflate(inflater, parent, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            btnCreateAccount.setOnClickListener {
                val direction = GettingStartedFragmentDirections
                    .actionFragmentGettingStartedToFragmentVerificationMethod()
                navigate(direction)
            }
        }
    }
}