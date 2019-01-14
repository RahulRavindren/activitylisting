package com.redbussearch.data.cache

import com.activitylisting.domain.entity.RedbusEntity
import com.redbussearch.data.store.RebusSearchCache

/**
 * @Author rahulravindran
 */
class RedbusCacheImpl : RebusSearchCache {

    override fun saveSearchListing(searchList: RedbusEntity) {

    }

    override fun getSearchListing(): RedbusEntity {
        throw  UnsupportedOperationException()
    }

    override fun isCached(): Boolean {
        return false
    }

    override fun setLastCacheTime(lastCache: Long) {
        throw UnsupportedOperationException()
    }

    override fun isExpired(): Boolean {
        return false
    }
}