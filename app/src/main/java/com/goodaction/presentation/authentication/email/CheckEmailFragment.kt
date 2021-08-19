package com.goodaction.presentation.authentication.email

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.goodaction.base.BaseFragment
import com.goodaction.databinding.FragmentCheckEmailBinding

class CheckEmailFragment : BaseFragment<FragmentCheckEmailBinding>() {

    override fun getRootBinding(
        inflater: LayoutInflater,
        parent: ViewGroup?
    ): FragmentCheckEmailBinding {
        return FragmentCheckEmailBinding.inflate(inflater, parent, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}