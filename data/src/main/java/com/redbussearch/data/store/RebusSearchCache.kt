package com.redbussearch.data.store

import com.activitylisting.domain.entity.RedbusEntity

/**
 * @Author rahulravindran
 */
interface RebusSearchCache {
    fun saveSearchListing(searchList: RedbusEntity)
    fun getSearchListing(): RedbusEntity
    fun isCached(): Boolean
    fun setLastCacheTime(lastCache: Long)
    fun isExpired(): Boolean

}