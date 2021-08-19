package com.goodaction.utils.extensions

import java.util.concurrent.TimeUnit

fun Long.toSeconds() = TimeUnit.MILLISECONDS.toSeconds(this)