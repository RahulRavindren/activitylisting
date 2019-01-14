package com.redbussearch.network.interceptors

import com.activitylisting.common.utils.Utils
import com.redbussearch.network.NetworkSDK
import okhttp3.Interceptor
import okhttp3.Response
import surveyapp.com.network.R
import com.redbussearch.network.exceptions.NetworkConnectivityException
import com.redbussearch.network.utils.NetworkUtils

/**
 * @Author rahulravindran
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