package com.goodaction.presentation.authentication.password

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
import androidx.core.view.doOnLayout
import androidx.core.view.isGone
import androidx.core.view.updateLayoutParams
import androidx.transition.TransitionManager
import com.goodaction.R
import com.goodaction.base.BaseFragment
import com.goodaction.databinding.FragmentForgotPasswordBinding
import com.goodaction.presentation.authentication.fragments.OTPFragment
import com.goodaction.utils.GoodActionTabSelectedListener
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.Tab
import kotlin.properties.Delegates

class ForgotPasswordFragment : BaseFragment<FragmentForgotPasswordBinding>() {

    private var tabIndicationWidth = 0

    private var verificationType: Int by Delegates.observable(TYPE_EMAIL) { _, _, newValue ->
        with(binding) {
            TransitionManager.beginDelayedTransition(root)
            val message = if (newValue == TYPE_PHONE) {
                ilPhoneNumber.isGone = false
                ilEmail.isGone = true
                getString(R.string.enter_the_detail, "phone number")
            } else {
                ilPhoneNumber.isGone = true
                ilEmail.isGone = false
                getString(R.string.enter_the_detail, "email address")
            }
            tvEnterDetails.text = message
        }
    }

    override fun getRootBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): FragmentForgotPasswordBinding {
        return FragmentForgotPasswordBinding.inflate(inflater, parent, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupTabIndicator()
        setupTabClickListener()
        verificationType = TYPE_EMAIL
        with(binding) {
            btnContinue.setOnClickListener {
                val direction = if (verificationType == TYPE_EMAIL) {
                    ForgotPasswordFragmentDirections.actionFragmentForgotPasswordToFragmentCheckEmail()
                } else {
                    ForgotPasswordFragmentDirections.actionFragmentForgotPasswordToFragmentOtp(
                        from = OTPFragment.FROM_FORGOT_PASSWORD
                    )
                }
                navigate(direction)
            }
        }
    }

    private fun setupTabIndicator() {
        with(binding) {
            tbSignInOptions.doOnLayout {
                tabIndicationWidth = it.width / (it as TabLayout).tabCount
                tabIndicator.updateLayoutParams<LayoutParams> {
                    width = tabIndicationWidth
                }
            }
        }
    }

    private fun setupTabClickListener() {
        with(binding) {
            tbSignInOptions.addOnTabSelectedListener(object : GoodActionTabSelectedListener() {
                override fun onTabSelected(tab: Tab) {
                    TransitionManager.beginDelayedTransition(this@with.root)
                    val positionOffset = tab.position * tabIndicationWidth
                    tabIndicator.updateLayoutParams<LayoutParams> {
                        // This accommodates for the trailing space in the design
                        marginStart = if (tab.position == 0) positionOffset + TRAILING_MARGIN
                        else positionOffset - TRAILING_MARGIN
                    }
                    verificationType = if (tab.position == 0) TYPE_EMAIL else TYPE_PHONE
                }
            })
        }
    }

    companion object {
        private const val TYPE_PHONE = 0
        private const val TYPE_EMAIL = 1
        private const val TRAILING_MARGIN = 16
    }
}