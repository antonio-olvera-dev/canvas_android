package com.example.canvas.data.service

import com.example.canvas.data.model.SignatureRequest

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body

import retrofit2.http.POST

import retrofit2.http.Multipart


interface SignatureClient {
   
    @POST("api/v3/upload/signature")
    fun uploadSignature(@Body request:SignatureRequest): Call<List<SignatureRequest>>

}