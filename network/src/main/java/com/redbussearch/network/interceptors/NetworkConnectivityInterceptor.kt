package com.redbussearch.network.interceptors

import com.activitylisting.common.utils.Utils
import com.redbussearch.network.NetworkSDK
import com.redbussearch.network.utils.NetworkUtils
import okhttp3.Interceptor
import okhttp3.Response
import surveyapp.com.network.R

/**
 * @Author rahulravindran
 * Interceptor class that checks network state during request call
 */
class NetworkConnectivityInterceptor : BaseInterceptor() {

    override fun intercept(chain: Interceptor.Chain?): Response {
        if (!NetworkUtils.isNetworkConnected()) {
            Utils.eventSubject.onNext(Utils.Event(NetworkSDK.mContext?.getString(R.string.no_network_msg),
                    Throwable(NetworkSDK.mContext?.getString(R.string.no_network_msg))))
        }
        return response(chain)
    }

}