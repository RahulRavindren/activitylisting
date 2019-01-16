package com.activitylisting.data.cache

import com.activitylisting.data.store.ListingCacheStore
import com.activitylisting.domain.entity.CategoryEntity
import com.activitylisting.domain.entity.CollectionEntity
import com.activitylisting.domain.entity.ListingEntity
import io.reactivex.Completable
import io.reactivex.Flowable

/**
 * @Author rahulravindran
 */
class CacheStoreImpl : ListingCacheStore<ListingEntity> {

    override fun getListing(category: CategoryEntity): Flowable<ListingEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveListing(data: Any): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearListing(): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isCached(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isExpired(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}