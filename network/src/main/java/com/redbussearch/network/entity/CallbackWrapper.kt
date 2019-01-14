package com.redbussearch.network.entity

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @Author rahulravindran
 */
interface ResponseCallback<R> {
    fun response(body: R)
    fun error(t: Throwable)
}

class CallbackWrapper<T>(val callback: ResponseCallback<T>) : Callback<T> {

    override fun onFailure(call: Call<T>, t: Throwable) {
        callback.error(t)
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        //based on response code covert response to actions needed on the application
        //single use case of 200
        if (response.isSuccessful) {
            callback.response(response.body()!!)
        }
    }
}