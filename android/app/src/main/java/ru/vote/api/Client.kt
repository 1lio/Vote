package ru.vote.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.vote.config.AppConfig.BASE_URL

class Client {

    private val interceptor = HttpLoggingInterceptor()
    private val retrofit: Retrofit
    private val api:Api

    init {
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().addInterceptor(interceptor).build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(Api::class.java)
    }

}