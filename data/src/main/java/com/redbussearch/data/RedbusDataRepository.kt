package com.redbussearch.data

import com.activitylisting.domain.entity.RedbusEntity
import com.redbussearch.data.source.RedbusSearchListingDataSourceFactory

/**
 * @Author rahulravindran
 */
class RedbusDataRepository(
    private val factory: RedbusSearchListingDataSourceFactory
) : RedbusListingRepository {

    override fun getBusListing(): RedbusEntity? {
        if (factory.retrieveSearchListingCache().isCached()) {
            return factory.retrieveSearchListingCache().getSearchListing()
        } else {
            return factory.retrieveSearchListingRemote().getSearchListing()
        }
    }
}