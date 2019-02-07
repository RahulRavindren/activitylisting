package com.redbussearch.cache

import com.nytimes.android.external.store3.base.Fetcher
import com.nytimes.android.external.store3.base.impl.BarCode
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer


interface RequestHandler<T> {
    fun request(): Single<T>
}

class FetcherClass<T>(
    val requestHandler: RequestHandler<T>,
    val globalErrorHandler: Consumer<Throwable>
) : Fetcher<T, BarCode> {
    override fun fetch(key: BarCode): Single<T> {;
        return requestHandler.request()
            .observeOn(AndroidSchedulers.mainThread())
            .doOnError(globalErrorHandler)
            .onErrorResumeNext(Single.never())
    }
}