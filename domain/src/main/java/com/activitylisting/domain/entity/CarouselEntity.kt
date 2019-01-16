package com.activitylisting.domain.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @Author rahulravindran
 */
data class CarouselEntity(
    @SerializedName("seq_no") val seqNo: Int,
    val images: List<ImageEntity>,
    val product:String,
    val subTitle:String,
    val callback:String,
    @SerializedName("tag_text") val tagText:String,
    val id:Int,
    val title:String,
    val type:String
): Serializable

