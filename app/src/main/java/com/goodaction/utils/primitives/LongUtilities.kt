package com.goodaction.utils.primitives

import java.util.concurrent.TimeUnit

fun Long.toSeconds() = TimeUnit.MILLISECONDS.toSeconds(this)