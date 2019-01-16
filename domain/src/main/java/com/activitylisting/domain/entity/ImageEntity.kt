package com.activitylisting.domain.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @Author rahulravindran
 */
data  class ImageEntity(
    @SerializedName("vibrant_color") val vibrantColor: String,
    @SerializedName("order_no") val orderNo: String,
    val img: String
) :Serializable