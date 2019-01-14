package com.activitylisting.common.basecommons

import androidx.lifecycle.ViewModel

/**
 * @Author rahulravindran
 */
abstract  class BaseViewModel: ViewModel() {
    abstract fun start()
    abstract fun stop()
}