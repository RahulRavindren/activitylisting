package com.activitylisting.common.interfaces

import android.content.Context

/**
 * @Author rahulravindran
 */
interface BaseView {
    fun showProgress(state:Boolean)
    fun showErrorPage(state: Boolean)
}