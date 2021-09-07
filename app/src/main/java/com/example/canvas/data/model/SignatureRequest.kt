package com.example.canvas.data.model

import com.google.gson.annotations.SerializedName
import okhttp3.MultipartBody

data class SignatureRequest(
    @SerializedName("bookingId") val teacherId: String,
    @SerializedName("fileStudent") val fileStudent: String,
    @SerializedName("fileTeacher") val fileTeacher: String,
)



