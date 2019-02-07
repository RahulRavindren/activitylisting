package com.activitylisting.common.interfaces

/**
 * @Author rahulravindran
 */
interface NetworkViewType {

    //for network connection
    fun onNetworkError()

    //server based error exception transform
    fun onNetworkError(exception: ServerException)

    //refined message and code
    fun onNetworkError(message: String, code: Int)
}