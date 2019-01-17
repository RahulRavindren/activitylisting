package com.activitylisting.data.cache

import com.activitylisting.common.utils.Utils
import com.activitylisting.data.network.NetworkStoreImpl
import com.activitylisting.data.store.ListingCacheStore
import com.activitylisting.domain.entity.CategoryEntity
import com.activitylisting.domain.entity.ListingEntity
import com.redbussearch.cache.CacheUtils
import com.redbussearch.cache.DEFUALT_CACHE_SIZE
import com.redbussearch.cache.FetcherClass
import com.redbussearch.cache.InternalStoreCache
import io.reactivex.Completable
import io.reactivex.Single

/**
 * @Author rahulravindran
 */

class CacheStoreImpl() : ListingCacheStore<ListingEntity> {
    private var mCacheStore = InternalStoreCache(Utils.getCacheDir(), DEFUALT_CACHE_SIZE)
        .providesStoreBuilder(FetcherClass(NetworkStoreImpl()))


    override fun getListing(category: CategoryEntity?): Single<ListingEntity> {
        return mCacheStore.get(CacheUtils.DEFUALT_BARCODE)
    }

    override fun saveListing(data: Any): Completable {
        throw UnsupportedOperationException()
    }

    override fun clearListing(): Completable {
        throw UnsupportedOperationException()
    }

    override fun isCached(): Single<Boolean> {
        throw UnsupportedOperationException()
    }

    override fun isExpired(): Single<Boolean> {
        throw UnsupportedOperationException()
    }
}