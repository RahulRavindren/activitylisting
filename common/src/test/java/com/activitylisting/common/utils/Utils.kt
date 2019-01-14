package com.activitylisting.common.utils

import okhttp3.mockwebserver.MockWebServer

object Utils {
    fun mockServer(): MockWebServer {
        return MockWebServer()
    }
}