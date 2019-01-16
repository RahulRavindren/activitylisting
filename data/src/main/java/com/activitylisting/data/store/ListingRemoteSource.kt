package com.activitylisting.data.store

import io.reactivex.Flowable
import io.reactivex.Single

/**
 * @Author rahulravindran
 */
interface ListingRemoteSource<T>{
    fun fetchListing(): Flowable<T>
}