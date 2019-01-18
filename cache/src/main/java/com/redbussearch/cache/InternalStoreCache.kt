package com.redbussearch.cache

import com.nytimes.android.external.store3.base.Fetcher
import com.nytimes.android.external.store3.base.impl.BarCode
import com.nytimes.android.external.store3.base.impl.MemoryPolicy
import com.nytimes.android.external.store3.base.impl.ParsingStoreBuilder
import com.nytimes.android.external.store3.base.impl.Store
import okio.BufferedSource
import java.io.File

const val DEFUALT_CACHE_SIZE: Long = 1024 * 10

class InternalStoreCache(val mFileDir: File, val cacheSize: Long) {


    fun <RAW> providesStoreBuilder(fetcher: FetcherClass<RAW>): Store<RAW, BarCode> {
        return ParsingStoreBuilder.builder<BufferedSource, RAW>()
            .fetcher(fetcher as Fetcher<BufferedSource, BarCode>)
            .memoryPolicy(buildMemoryPolicy())
            .open()
    }

    private fun buildMemoryPolicy(): MemoryPolicy {
        return MemoryPolicy.MemoryPolicyBuilder()
            .setMemorySize(DEFUALT_CACHE_SIZE)
            .setExpireAfter(30000).build()
    }


}