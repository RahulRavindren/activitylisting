package com.redbussearch.data.injection

import com.redbussearch.data.RedbusDataRepository
import com.redbussearch.data.cache.RedbusCacheImpl
import com.redbussearch.data.remote.services.FetchResultPageService
import com.redbussearch.data.source.RedbusSearchListingCacheStore
import com.redbussearch.data.source.RedbusSearchListingDataSourceFactory
import com.redbussearch.data.source.RedbusSearchListingRemoteStore

/**
 * @Author rahulravindran
 */
class DataInjection {
    companion object {
        fun provideDataSourceFactory(): RedbusSearchListingDataSourceFactory {
            return RedbusSearchListingDataSourceFactory(
                provideCacheImpl(),
                RedbusSearchListingCacheStore(provideCacheImpl()),
                RedbusSearchListingRemoteStore(provideRemoteService())
            )
        }

        fun provideCacheImpl(): RedbusCacheImpl {
            return RedbusCacheImpl()
        }

        fun provideRemoteService(): FetchResultPageService {
            return FetchResultPageService()
        }


        fun provideDataRepository(): RedbusDataRepository {
            return RedbusDataRepository(provideDataSourceFactory())
        }
    }
}