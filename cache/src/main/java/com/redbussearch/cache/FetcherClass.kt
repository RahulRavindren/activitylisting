package com.redbussearch.cache

import com.nytimes.android.external.store3.base.Fetcher
import com.nytimes.android.external.store3.base.impl.BarCode
import io.reactivex.Single


interface RequestHandler<T> {
    fun request(): Single<T>
}

class FetcherClass<T>(val requestHandler: RequestHandler<T>) : Fetcher<T, BarCode> {
    override fun fetch(key: BarCode): Single<T> {
        return requestHandler.request()
    }
}