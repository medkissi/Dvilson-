package com.medkissi.satplayhometest.di

import com.medkissi.satplayhometest.data.remote.ApIService
import com.medkissi.satplayhometest.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }




    @Singleton
    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        val okHttpClient = OkHttpClient().newBuilder()
        okHttpClient.addInterceptor(loggingInterceptor)
        okHttpClient.readTimeout(15, TimeUnit.SECONDS)
        okHttpClient.connectTimeout(15, TimeUnit.SECONDS)
        okHttpClient.build()
        return okHttpClient.build()
    }



    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    @Singleton
    @Provides
    fun providePostService(retrofit: Retrofit): ApIService=
        retrofit.create(ApIService::class.java)

}