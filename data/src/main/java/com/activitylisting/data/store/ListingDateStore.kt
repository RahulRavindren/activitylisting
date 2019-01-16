package com.activitylisting.data.store

import com.activitylisting.domain.entity.CategoryEntity
import com.activitylisting.domain.entity.CollectionEntity
import com.activitylisting.domain.entity.ListingEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * @Author rahulravindran
 */
interface ListingDateStore<T>{
    fun clearListing(): Completable
    fun getListing(): Flowable<T>
    fun saveListing(data:Any): Completable
    fun isCached(): Single<Boolean>
}