package com.redbussearch.network

import com.redbussearch.network.interceptors.ApplicationMetaDataInterceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class ApplicationMetaDataInterceptorTest {

    private val server = MockWebServer()

    @Before
    fun setUp() {
        server.start()
        server.enqueue(MockResponse())
    }

    @Test
    fun `meta data param test`() {
        val okHttpClient = OkHttpClient().newBuilder()
                .addInterceptor(ApplicationMetaDataInterceptor()).build()
        okHttpClient.newCall(Request.Builder().url(server.url("/")).build()).execute()

        val requestRecord = server.takeRequest()
        Assert.assertEquals(AppConfigBuilder.getInstance()?.applicationVersion,
                requestRecord.getHeader("APPLICATION_VERSION_NAME"))

        Assert.assertEquals(AppConfigBuilder.getInstance()?.applicationId,
                requestRecord.getHeader("APPLICATION_ID"))
        Assert.assertEquals(AppConfigBuilder.getInstance()?.applicationCode.toString(),
                requestRecord.getHeader("APPLICATION_VERISON_CODE"))

        server.shutdown()

    }
}