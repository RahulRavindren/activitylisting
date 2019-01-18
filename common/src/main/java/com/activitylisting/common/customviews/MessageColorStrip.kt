package com.activitylisting.common.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.widget.TextView

class MessageColorStrip : TextView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    fun setText(value: String?, bgColor: Int, textColor: Int) {
        if (text == null) {
            visibility = View.GONE
            return
        }
        super.setText(value)
        gravity = Gravity.CENTER
        setTextColor(textColor)
        setBackgroundColor(bgColor)
    }
}