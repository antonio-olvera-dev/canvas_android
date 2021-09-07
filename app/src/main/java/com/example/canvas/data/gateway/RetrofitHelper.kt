package com.example.canvas.data.gateway

    import retrofit2.Retrofit
    import retrofit2.converter.gson.GsonConverterFactory

    object RetrofitHelper {
        fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("http://localhost:3024")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
