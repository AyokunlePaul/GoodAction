package com.goodaction.presentation.authentication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.goodaction.R
import com.goodaction.base.BaseFragment
import com.goodaction.databinding.FragmentGettingStartedBinding
import com.goodaction.presentation.authentication.AuthenticationActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.properties.Delegates

@AndroidEntryPoint
class GettingStartedFragment : BaseFragment<FragmentGettingStartedBinding>() {

    private val viewModel by hiltNavGraphViewModels<AuthenticationActivityViewModel>(
        R.navigation.nav_authentication
    )

    private var signInType: Int by Delegates.observable(TYPE_NORMAL) { _, _, newValue ->
        with(binding) {
            if (newValue == TYPE_SOCIAL) {
                gpSocialLogin.visibility = View.GONE
                tvGettingStarted.text = getString(R.string.confirm_details)
            } else {
                gpSocialLogin.visibility = View.VISIBLE
                tvGettingStarted.text = getString(R.string.getting_started)
            }
        }
    }

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
            cvFacebook.setOnClickListener { signInType = TYPE_SOCIAL }
            cvGoogle.setOnClickListener { signInType = TYPE_SOCIAL }
        }
    }

    companion object {
        const val TYPE_NORMAL = 0
        const val TYPE_SOCIAL = 1
    }
}