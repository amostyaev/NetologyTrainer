package com.raistlin.netologysample.net

import java.net.HttpURLConnection
import java.net.URL

class JSONRequester {

    fun requestJSON(): String {
        val url = URL(URL)
        val urlConnection = url.openConnection() as HttpURLConnection
        urlConnection.connectTimeout = TIMEOUT_CONNECTION
        urlConnection.readTimeout = TIMEOUT_READ
        if (urlConnection.responseCode != HttpURLConnection.HTTP_OK) {
            urlConnection.disconnect()
            throw RuntimeException("Http error: ${urlConnection.responseCode}")
        }
        return urlConnection.inputStream.bufferedReader().use { it.readText() }
    }

    companion object {
        const val URL = "https://raw.githubusercontent.com/netology-code/rn-task/master/netology.json"

        const val TIMEOUT_CONNECTION = 1000
        const val TIMEOUT_READ = 5000
    }
}