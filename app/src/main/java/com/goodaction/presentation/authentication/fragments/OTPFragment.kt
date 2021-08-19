package com.goodaction.presentation.authentication.fragments

import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.goodaction.R
import com.goodaction.base.BaseFragment
import com.goodaction.databinding.FragmentOtpBinding
import com.goodaction.utils.extensions.maskNumber
import com.goodaction.utils.extensions.toSeconds
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OTPFragment : BaseFragment<FragmentOtpBinding>() {

    private val navArg by navArgs<OTPFragmentArgs>()
    private val timer = object : CountDownTimer(30_000, 1_000) {
        override fun onTick(millisUntilFinished: Long) {
            binding.tvExpiryCountdown.text =
                getString(R.string.expiry_countdown, millisUntilFinished.toSeconds())
        }

        override fun onFinish() {

        }
    }

    override fun getRootBinding(inflater: LayoutInflater, parent: ViewGroup?): FragmentOtpBinding {
        return FragmentOtpBinding.inflate(inflater, parent, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            tvPhone.text = navArg.phone.maskNumber()
        }
        timer.start()
    }

    override fun onDestroyView() {
        timer.cancel()
        super.onDestroyView()
    }
}