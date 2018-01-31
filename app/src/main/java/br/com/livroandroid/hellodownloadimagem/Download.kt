package br.com.livroandroid.hellodownloadimagem

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.net.URL

object Download {
    fun downloadBitMap(url: String): Bitmap {
        URL(url).openStream().use {
            return BitmapFactory.decodeStream(it)
        }
    }
}