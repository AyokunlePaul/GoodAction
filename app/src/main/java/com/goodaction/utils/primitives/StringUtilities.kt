package com.goodaction.utils.primitives

fun String.maskNumber(): String {
    return "${substring(0 until 2)}****${substring(length - 4, length - 1)}"
}