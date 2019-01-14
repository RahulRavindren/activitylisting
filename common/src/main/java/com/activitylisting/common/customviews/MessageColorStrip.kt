package com.activitylisting.common.customviews

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView

class MessageColorStrip : TextView {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    init {
        init()
    }

    private fun init() {

    }
}