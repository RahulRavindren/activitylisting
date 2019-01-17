package com.activitylisting.data.source

import com.activitylisting.data.store.ListingCacheStore
import com.activitylisting.data.store.ListingDateStore
import com.activitylisting.domain.entity.CategoryEntity
import com.activitylisting.domain.entity.ListingEntity
import io.reactivex.Completable
import io.reactivex.Single

/**
 * @Author rahulravindran
 */
class ListingCacheSource(val cacheStore:ListingCacheStore<ListingEntity>): ListingDateStore<ListingEntity>{
    override fun clearListing(): Completable {
        return Completable.complete()
    }

    override fun getListing(categoryEntity: CategoryEntity?): Single<ListingEntity> {
        return cacheStore.getListing(categoryEntity)
    }

    override fun saveListing(data: Any): Completable {
        return cacheStore.saveListing(data)
    }

    override fun isCached(): Single<Boolean> {
        return cacheStore.isCached()
    }
}