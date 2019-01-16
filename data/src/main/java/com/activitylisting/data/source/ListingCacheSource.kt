package com.activitylisting.data.source

import com.activitylisting.data.store.ListingCacheStore
import com.activitylisting.data.store.ListingDateStore
import com.activitylisting.domain.entity.CategoryEntity
import com.activitylisting.domain.entity.CollectionEntity
import com.activitylisting.domain.entity.ListingEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single

/**
 * @Author rahulravindran
 */
class ListingCacheSource(val cacheStore:ListingCacheStore<ListingEntity>): ListingDateStore<ListingEntity>{

    override fun clearListing(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getListing(): Flowable<ListingEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveListing(data: Any): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isCached(): Single<Boolean> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}