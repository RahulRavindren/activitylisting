package com.activitylisting.data.store

import com.activitylisting.domain.entity.CategoryEntity
import io.reactivex.Completable
import io.reactivex.Single

/**
 * @Author rahulravindran
 */
interface ListingDateStore<T>{
    fun clearListing(): Completable
    fun getListing(categoryEntity: CategoryEntity?): Single<T>
    fun saveListing(data:Any): Completable
    fun isCached(): Single<Boolean>
}