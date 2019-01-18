package com.activitylisting.common.utils

import android.graphics.Bitmap
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.FutureTarget
import surveyapp.com.common.BuildConfig

/**
 * @Author rahulravindran
 */
class Image {

    companion object {
        val glide = Glide.with(Utils.application?.applicationContext!!)
            .asBitmap()

        fun loadBG(url: String, imageView: ImageView): FutureTarget<Bitmap> {
            return glide.load(replaceUrlParams(url))
                .submit(imageView.measuredWidth, imageView.measuredHeight)
        }

        fun load(url: String, imageView: ImageView) {
            glide.load(replaceUrlParams(url))
                .into(imageView)
        }

        fun replaceUrlParams(url: String): String {
            return BuildConfig.IMAGE_BASE_URL + url.replace("{type}", "w")
        }

    }
}