package com.redbussearch.network

import android.content.SharedPreferences
import com.redbussearch.common.entity.AppCredentialPreference
import com.redbussearch.common.utils.PreferenceManager
import io.mockk.mockk
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ApplicationHeaderInterceptorTest {

    private val server = MockWebServer()
    private val token = "adasddffhdufgutg973nkjnsfuhf989"

    private val pref = mockk<PreferenceManager>(relaxed = true)
    private val sharePref = Mockito.mock(SharedPreferences::class.java)


    @Before
    fun setUp() {
        server.start()
        server.enqueue(MockResponse())
    }

    @Test
    fun `test token as query param`() {
        val okHttpClient = OkHttpClient().newBuilder()
                .addInterceptor(ApplicationHeaderInterceptor()).build()
        okHttpClient.newCall(Request.Builder().url(server.url("/")).build()).execute()

        val requestRecord = server.takeRequest()
        Assert.assertNull(requestRecord.getHeader("access_token"))
        server.shutdown()
    }

    @Test
    fun `test token query param after saving in savedPref`() {
        val okHttpClient = OkHttpClient().newBuilder()
                .addInterceptor(ApplicationHeaderInterceptor()).build()

        pref.savePreference(AppCredentialPreference.ACCESS_TOKEN, token)

        okHttpClient.newCall(Request.Builder().url(server.url("/")).build()).execute()

        val requestRecord = server.takeRequest()
        Assert.assertEquals(token, requestRecord.getHeader("access_token"))

        server.shutdown()
    }

}