package com.acitivylisting

import android.app.Application
import com.activitylisting.common.utils.AppConfigBuilder
import com.activitylisting.common.utils.ApplicationUrlContainer
import com.activitylisting.common.utils.Logger
import com.activitylisting.common.utils.Utils
import com.redbussearch.network.NetworkSDK
import com.redbussearch.network.interceptors.ApplicationMetaDataInterceptor
import com.redbussearch.network.interceptors.NetworkConnectivityInterceptor
import okhttp3.Interceptor

/**
 * @Author rahulravindran
 */
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Logger.init()
        Utils.application = this
        NetworkSDK.init(
            applicationContext, *arrayOf<Interceptor>(
                ApplicationMetaDataInterceptor(),
                NetworkConnectivityInterceptor()
            )
        )


        //generate application baseurl
        ApplicationUrlContainer
            .init(ApplicationUrlContainer.Builder().apply {
                applicationBaseUrl = BuildConfig.BASE_URL
            })

        AppConfigBuilder
            .getInstance(AppConfigBuilder.Builder().apply {
                setApplicationCode(BuildConfig.VERSION_CODE)
                setApplicationEnv(BuildConfig.FLAVOR)
                setApplicationID(BuildConfig.APPLICATION_ID)
                setApplicationVersion(BuildConfig.VERSION_NAME)
            })

    }
}