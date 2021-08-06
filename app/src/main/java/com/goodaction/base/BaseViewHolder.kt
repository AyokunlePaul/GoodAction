package com.goodaction.base

abstract class BaseViewHolder <D> {
    abstract fun bind(data: D)
}