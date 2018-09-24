package com.florangoutang.deezertest.data

import com.florangoutang.deezertest.entity.Album
import com.florangoutang.deezertest.interfaceadapter.album.detail.model.AlbumDetailRemoteModel
import com.florangoutang.deezertest.interfaceadapter.album.list.model.AlbumListRemoteModel
import io.reactivex.Flowable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface AlbumRetrofitDataSource {

    @GET("/2.0/user/2529/albums")
    fun fetchAlbumList(@Query("index") offset: Int): Flowable<AlbumListRemoteModel>

    @GET("/2.0/album/{album_id}")
    fun fetchAlbumDetail(@Path("album_id") albumId: Int): Flowable<AlbumDetailRemoteModel>

    class AlbumRetrofitApiBuilder {

        private val deezerApi: AlbumRetrofitDataSource

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

            deezerApi = retrofit.create(AlbumRetrofitDataSource::class.java)
        }

        fun getDeezerApi(): AlbumRetrofitDataSource {
            return deezerApi
        }


    }
}