package com.envamapa.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class NetworkImpl @Inject constructor() : Network {

    private lateinit var client: OkHttpClient
    private var retrofit: Retrofit

    init {
        getClient()
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
    }

    private fun getClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
        builder.connectTimeout(SERVICE_TIME_IN_SECONDS, TimeUnit.SECONDS)
        builder.readTimeout(SERVICE_TIME_IN_SECONDS, TimeUnit.SECONDS)
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        builder.addInterceptor(logging)

        client = builder.build()
        return client
    }

    override fun <T> getServices(clazz: Class<T>): T =
        retrofit.create(clazz)

    companion object {
        private const val SERVICE_TIME_IN_SECONDS: Long = 40
        private const val BASE_URL = "https://cdn.jsdelivr.net"
    }
}
