package com.activitylisting.data.source

import com.activitylisting.data.store.ListingCacheStore
import com.activitylisting.data.store.ListingDateStore
import com.activitylisting.domain.entity.ListingEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * @Author rahulravindran
 */
class ListingCacheSource(val cacheStore:ListingCacheStore<ListingEntity>): ListingDateStore<ListingEntity>{

    override fun clearListing(): Completable {
        return Completable.complete()
    }

    override fun getListing(): Flowable<ListingEntity> {
        return Flowable.empty()
    }

    override fun saveListing(data: Any): Completable {
        return Completable.complete()
    }

    override fun isCached(): Single<Boolean> {
        return Single.just(false)
    }
}