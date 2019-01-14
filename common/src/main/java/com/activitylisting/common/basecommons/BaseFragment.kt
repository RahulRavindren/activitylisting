package com.activitylisting.common.basecommons

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.activitylisting.common.C
import com.activitylisting.common.utils.Logger

/**
 * @Author rahulravindran
 */
open class BaseFragment : Fragment() {
    protected var isViewVisible: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        Logger.debug(C.LIFE_CYCLE, "fragment start");
        super.onStart()
    }

    override fun onResume() {
        Logger.debug(C.LIFE_CYCLE, "fragment resume");
        super.onResume()
    }

    override fun onPause() {
        Logger.debug(C.LIFE_CYCLE, "fragment pause");
        super.onPause()
    }

    override fun onDestroy() {
        Logger.debug(C.LIFE_CYCLE, "fragment destroy");
        super.onDestroy()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        isViewVisible = isVisibleToUser
        super.setUserVisibleHint(isVisibleToUser)
    }

}