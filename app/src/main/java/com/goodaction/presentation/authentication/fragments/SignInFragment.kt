package com.goodaction.presentation.authentication.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
import androidx.core.view.doOnLayout
import androidx.core.view.updateLayoutParams
import androidx.transition.TransitionManager
import com.goodaction.base.BaseFragment
import com.goodaction.databinding.FragmentSignInBinding
import com.goodaction.utils.GoodActionTabSelectedListener
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.Tab
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInFragment : BaseFragment<FragmentSignInBinding>() {

    private var tabIndicationWidth: Int = 0

    override fun getRootBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): FragmentSignInBinding {
        return FragmentSignInBinding.inflate(inflater, parent, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupTabIndicator()
        setupTabClickListener()
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
                }
            })
        }
    }

    companion object {
        private const val TRAILING_MARGIN = 8
    }
}