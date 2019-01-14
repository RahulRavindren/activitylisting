package com.redbussearch.network.interceptors

import com.activitylisting.common.utils.AppConfigBuilder
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @Author rahulravindran
 */
class ApplicationMetaDataInterceptor : BaseInterceptor() {

    override fun intercept(chain: Interceptor.Chain?): Response {
        val request = request(chain)
        val requestBuilder = request!!.newBuilder()
                .addHeader("APPLICATION_VERSION_NAME",
                        AppConfigBuilder.getInstance()?.applicationVersion)
                .addHeader("APPLICATION_ID",
                        AppConfigBuilder.getInstance()?.applicationId)
                .addHeader("APPLICATION_VERISON_CODE",
                        AppConfigBuilder.getInstance()?.applicationCode.toString())
        return response(chain, requestBuilder.build())
    }
}