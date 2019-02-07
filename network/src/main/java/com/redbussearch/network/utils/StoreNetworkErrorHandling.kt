package com.redbussearch.network.utils

import com.redbussearch.network.entity.NetworkViewType
import com.redbussearch.network.exceptions.ServerException
import io.reactivex.functions.Consumer
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

/**
 * @Author rahulravindran
 */
class StoreNetworkErrorHandling(val listener: NetworkViewType) : Consumer<Throwable> {

    override fun accept(e: Throwable?) {
        if (listener == null) {
            throw NullPointerException("network type listener is null")
        }

        if (e is HttpException) {
            val httpException = e as HttpException
            listener?.onNetworkError(ServerException(e))

        } else if (e is SocketTimeoutException) {
            throw e
        } else if (e is IOException) {
            val exception = e as IOException
            listener.onNetworkError()
        }
    }

}