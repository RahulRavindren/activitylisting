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
import java.util.concurrent.TimeUnit

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
            var clientBuilder = OkHttpClient.Builder()
                .addInterceptor(NetworkConnectivityInterceptor())
                .addInterceptor(ApplicationMetaDataInterceptor())
                .readTimeout(READ_TIME_OUT, TimeUnit.MILLISECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.MILLISECONDS)

            if (BuildConfig.DEBUG) {
                clientBuilder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))

            }

            interceptors?.forEach { interceptor: Interceptor -> clientBuilder.addInterceptor(interceptor) }
            return clientBuilder.build()
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

