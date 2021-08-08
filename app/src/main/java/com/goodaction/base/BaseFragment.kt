package com.goodaction.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment <V: ViewBinding> : Fragment() {

    private var _binding: V? = null
    protected val binding: V get() = _binding!!

    abstract fun getRootBinding(inflater: LayoutInflater, parent: ViewGroup?): V

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getRootBinding(inflater, container)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}