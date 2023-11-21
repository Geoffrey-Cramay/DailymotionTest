package com.example.dailymotiontest.data.remote.di

import com.example.dailymotiontest.data.remote.VideosService
import com.example.dailymotiontest.data.remote.model.adapter.OffsetDateTimeJsonAdapter
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.time.OffsetDateTime
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteServiceModule {
    private const val BASE_URL = "https://api.dailymotion.com/"

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(interceptor).build()

    @Singleton
    @Provides
    fun provideOffsetDateTimeJsonAdapter() = OffsetDateTimeJsonAdapter()

    @Singleton
    @Provides
    fun provideMoshi(offsetDateTimeJsonAdapter: OffsetDateTimeJsonAdapter): Moshi =
        Moshi.Builder().add(OffsetDateTime::class.java, offsetDateTimeJsonAdapter.nullSafe())
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Singleton
    @Provides
    fun provideSongService(retrofit: Retrofit): VideosService =
        retrofit.create(VideosService::class.java)
}