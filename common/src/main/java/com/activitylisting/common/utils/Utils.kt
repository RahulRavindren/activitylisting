package com.activitylisting.common.utils

import android.app.Application
import android.content.Intent
import com.activitylisting.common.C
import io.reactivex.subjects.PublishSubject
import java.io.File
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

/**
 * @Author rahulravindran
 */
class Utils {
    companion object {
        var application: Application? = null
            set(value) {
                field = value
            }
            get() = field

        var debug: Boolean = true
        var eventSubject = PublishSubject.create<Event>()

        fun startActivity(intent: Intent) {
            application?.startActivity(intent)
        }


        fun getDeviceHeight(): Int {
            return application!!.resources.displayMetrics.heightPixels
        }

        fun getDeviceWidth(): Int {
            return application!!.resources.displayMetrics.widthPixels
        }


        fun getCacheDir(dirname: String): File {
            val cacheDir = application?.filesDir
            val httpCacheDir = File(cacheDir, dirname)
            if (httpCacheDir != null) {
                httpCacheDir.mkdirs()
            }
            return httpCacheDir
        }

        fun getString(id: Int): String? {
            return application?.getString(id)
        }

        fun getString(id:Int, vararg params:String): String? {
            return application?.getString(id, params)
        }


        fun getStringArray(id:Int): Array<String>? {
            return application?.resources?.getStringArray(id)
        }

        fun formatDate(pattern: String, date:String) : Date? {
            val dateFormat = SimpleDateFormat(pattern)
            try{
                val date = dateFormat.parse(date)
                return date
            } catch (e: ParseException) {
                e.printStackTrace()
                return null
            }
        }

        fun formateDate(pattern: String, date:Date?): String {
            val dateFormat = SimpleDateFormat(pattern)
            try{
                return dateFormat.format(date)
            } catch (e:ParseException) {
                e.printStackTrace()
                return C.EMPTY_STRING
            }
        }



    }

    data class Event(val message: String?, val throwable: Throwable)
}