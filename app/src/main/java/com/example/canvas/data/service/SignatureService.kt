package com.example.canvas.data.service

import android.util.Log
import com.example.canvas.data.gateway.RetrofitHelper
import com.example.canvas.data.model.SignatureRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call

class SignatureService {

    private val retrofit = RetrofitHelper.getRetrofit()
    private val retrofitCreate = retrofit.create(SignatureClient::class.java)

    suspend fun postSignature(signatureClient: SignatureRequest): List<SignatureRequest> {

        return withContext(Dispatchers.IO) {

            try {

                val call: Call<List<SignatureRequest>> = retrofitCreate.uploadSignature(signatureClient)
                call.execute().body() ?: emptyList()
            } catch (e: Exception) {
                Log.w("ERROR into SignatureClient: ",e)
                emptyList()
            }
        }
    }
}