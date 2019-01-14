package com.redbussearch.cache

import com.nytimes.android.external.fs3.FileSystemPersisterFactory
import com.nytimes.android.external.fs3.PathResolver
import com.nytimes.android.external.fs3.filesystem.FileSystemFactory
import com.nytimes.android.external.store3.base.Fetcher
import com.nytimes.android.external.store3.base.impl.*
import okio.BufferedSource
import java.io.File
import java.util.concurrent.TimeUnit


class InternalStoreCache<T>(val mFileDir: File, val cacheSize: Long) {


    private val DEFUALT_CACHE_SIZE: Long = 1024 * 10

    fun <RAW> providesStoreBuilder(fetcher: FetcherClass<RAW>): Store<RAW, BarCode> {

        return FluentStoreBuilder.parsedWithKey<BarCode, BufferedSource, RAW>(fetcher as Fetcher<BufferedSource, BarCode>) {
            memoryPolicy = buildMemoryPolicy()
            persister = FileSystemPersisterFactory.create(
                FileSystemFactory.create(mFileDir),
                PathResolver<BarCode> { key -> key.toString() })
            stalePolicy = StalePolicy.NETWORK_BEFORE_STALE
        }
    }

    private fun buildMemoryPolicy(): MemoryPolicy {
        return MemoryPolicy.MemoryPolicyBuilder()
            .setMemorySize(DEFUALT_CACHE_SIZE)
            .setExpireAfterTimeUnit(TimeUnit.SECONDS).build()
    }

}