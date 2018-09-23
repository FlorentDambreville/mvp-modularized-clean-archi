package com.florangoutang.deezertest.data

import com.florangoutang.deezertest.interfaceadapter.album.list.model.AlbumListRemoteModel
import io.reactivex.Flowable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumListRetrofitDataSource {

    @GET("/2.0/user/2529/albums")
    fun fetchAlbumList(@Query("index") offset: Int): Flowable<AlbumListRemoteModel>

    class AlbumRetrofitApiBuilder {

        private val deezerApi: AlbumListRetrofitDataSource

        init {
            // Add interceptors (with API KEY and Logging Level) && build httpclient
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor { chain ->
                val original = chain.request()
                val originalHttpUrl = original.url()
                val url = originalHttpUrl.newBuilder()
                        .build()
                val requestBuilder = original.newBuilder()
                        .url(url)
                val request = requestBuilder.build()
                chain.proceed(request)
            }.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

            val retrofit = Retrofit.Builder()
                    .baseUrl("http://api.deezer.com")
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()

            deezerApi = retrofit.create(AlbumListRetrofitDataSource::class.java)
        }

        fun getDeezerApi(): AlbumListRetrofitDataSource {
            return deezerApi
        }


    }
}