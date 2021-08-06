package com.goodaction.base

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment <V: ViewBinding> : Fragment() {

    abstract val binding: V
}