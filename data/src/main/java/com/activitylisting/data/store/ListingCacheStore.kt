package com.activitylisting.data.store

import com.activitylisting.domain.entity.CategoryEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * @Author rahulravindran
 */
interface ListingCacheStore<T>{
    fun getListing(category: CategoryEntity): Flowable<T>
    fun saveListing(data:Any): Completable
    fun clearListing(): Completable
    fun isCached(): Boolean
    fun isExpired(): Boolean

}