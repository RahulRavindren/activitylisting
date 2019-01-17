package com.activitylisting.data.store

import com.activitylisting.domain.entity.CategoryEntity
import io.reactivex.Completable
import io.reactivex.Single

/**
 * @Author rahulravindran
 */
interface ListingCacheStore<T>{
    fun getListing(category: CategoryEntity?): Single<T>
    fun saveListing(data:Any): Completable
    fun clearListing(): Completable
    fun isCached(): Single<Boolean>
    fun isExpired(): Single<Boolean>

}