package com.example.canvas.main_canvas.controller


import android.graphics.*
import android.util.Base64
import com.example.canvas.main_canvas.MainCanvas
import java.io.ByteArrayOutputStream


class MainCanvasController(val ctx: MainCanvas) {


    fun cleanView() {

        ctx.extraCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR)
        ctx.invalidate()
    }

    fun parseToJpeg(): String {

        val outputStream = ByteArrayOutputStream()
        ctx.extraBitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
        val byteArray: ByteArray = outputStream.toByteArray()
        return Base64.encodeToString(byteArray, Base64.DEFAULT)
    }


}