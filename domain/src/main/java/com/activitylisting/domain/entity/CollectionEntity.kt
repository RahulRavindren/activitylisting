package com.activitylisting.domain.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * @Author rahulravindran
 */
data class CollectionEntity(
     @SerializedName("vibrant_color") val vibrantColor:String,
     val image:String,
     val count:Int,
     @SerializedName("count_text") val countText:String,
     @SerializedName("collection_slug_url") val collectionSlugUrl: String,
     val rank: Int,
     val id: Int,
     val categories:List<String>,
     @SerializedName("collection_name") val collectionName: String,
     val desc:String,
     @SerializedName("seo_content") val seoContent:Map<String,String>
): Serializable