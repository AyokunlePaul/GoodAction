package com.goodaction.utils.span

import android.text.TextPaint
import android.text.style.ClickableSpan
import android.view.View

class GoodActionClickableSpan(
    private val action: () -> Unit
) : ClickableSpan() {

    override fun onClick(widget: View) {
        action.invoke()
    }

    override fun updateDrawState(ds: TextPaint) {
        super.updateDrawState(ds)
        ds.isUnderlineText = false
    }
}