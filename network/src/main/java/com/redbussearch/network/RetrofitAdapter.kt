package com.redbussearch.network

import com.activitylisting.common.utils.ApplicationUrlContainer
import com.redbussearch.network.interceptors.ApplicationMetaDataInterceptor
import com.redbussearch.network.interceptors.NetworkConnectivityInterceptor
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import surveyapp.com.network.BuildConfig
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

/**
 * @Author rahulravindran
 */

const val READ_TIME_OUT = 60000L
const val WRITE_TIME_OUT = 60000L

class RetrofitAdapter {

    companion object {


        fun retrofitClient(baseHost: HttpUrl, interceptors: Collection<Interceptor>?): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseHost)
                .client(NetworkSDK.client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        fun retrofitClient(interceptors: Collection<Interceptor>?): Retrofit {
            if (ApplicationUrlContainer.getInstance()?.getBaseUrl()?.appBaseUrl?.isEmpty()!!) {
                throw NullPointerException("base URL empty")
            }

            return retrofitClient(
                HttpUrl.Builder()
                    .scheme("https")
                    .host(ApplicationUrlContainer.getInstance()?.getBaseUrl()?.appBaseUrl).build(),
                interceptors
            )
        }

        fun getClient(interceptors: Collection<Interceptor>?): OkHttpClient {
            val trustManager = generateOpenTrustManager()
            var clientBuilder = OkHttpClient.Builder()
                .addInterceptor(NetworkConnectivityInterceptor())
                .sslSocketFactory(getSocketFactory(getSSLContext(trustManager)), trustManager[0] as X509TrustManager)
                .addInterceptor(ApplicationMetaDataInterceptor())
                .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.MILLISECONDS)

            if (BuildConfig.DEBUG) {
                clientBuilder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))

            }

            interceptors?.forEach { interceptor: Interceptor -> clientBuilder.addInterceptor(interceptor) }
            return clientBuilder.build()
        }

        private fun getSSLContext(certificateArray: Array<TrustManager>): SSLContext {
            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, certificateArray, SecureRandom())
            return sslContext
        }

        private fun getSocketFactory(sslContext: SSLContext): SSLSocketFactory {
            return sslContext.socketFactory
        }

        private fun generateOpenTrustManager(): Array<TrustManager> {
            return arrayOf(object : X509TrustManager {
                override fun checkClientTrusted(p0: Array<out X509Certificate>?, p1: String?) {}

                override fun checkServerTrusted(p0: Array<out X509Certificate>?, p1: String?) {}

                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return emptyArray()
                }
            })
        }



    }


    class Factory {
        public fun <T : Any?> getRestService(service: Class<T>, interceptors: Collection<Interceptor>?): T {
            return retrofitClient(interceptors).create(service)
        }

        public fun <T : Any?> getRestService(
            service: Class<T>,
            baseHost: String,
            interceptors: Collection<Interceptor>?
        ): T {
            return retrofitClient(
                HttpUrl.Builder().host(baseHost).build(),
                interceptors
            ).create(service)
        }
    }
}

