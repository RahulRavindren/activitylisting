package com.activitylisting.common.utils

import com.activitylisting.common.entity.BaseUrl

/**
 * @Author rahulravindran
 */
class ApplicationUrlContainer private constructor(){

    private object HOLDER {
        val INSTANCE by lazy {
            init(null)
            ApplicationUrlContainer()
        }
    }

    fun getBaseUrl() : BaseUrl?{
        checkNotNull(baseUrl)
        return baseUrl
    }


    companion object {
        private var baseUrl: BaseUrl? = null
        fun getInstance(): ApplicationUrlContainer? {
            return HOLDER.INSTANCE
        }

        fun init(builder: Builder?) {
            baseUrl =
                    BaseUrlBuilder.getStoredBaseUrl(Utils.application)
            if (baseUrl == null) {
                baseUrl = builder?.build()
                overrideUrl(builder)
            }
        }

        fun overrideUrl(builder: Builder?) {
            BaseUrlBuilder.overrideStoredBaseUrl(
                Utils.application,
                builder?.build()
            )
        }


    }


    class Builder {
        var applicationBaseUrl:String? = null
        var applicationAnalyticsUrl:String? = null
        var applicationBaseUrl1:String? = null

        fun build(): BaseUrl {
            return BaseUrl(
                applicationBaseUrl,
                applicationAnalyticsUrl,
                applicationBaseUrl1
            )
        }
    }




}