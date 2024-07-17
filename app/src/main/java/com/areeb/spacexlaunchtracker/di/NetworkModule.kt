package com.areeb.spacexlaunchtracker.di

import android.content.Context
import com.areeb.spacexlaunchtracker.data.ApiConstant
import com.areeb.spacexlaunchtracker.data.HomeService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    @Provides
    fun setGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(GsonBuilder().setLenient().create())
    }
    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }


    @Provides
    @Singleton
    fun provideApplicationContext(@ApplicationContext context: Context): Context {
        return context
    }


    @Provides
    @Singleton
    fun provideBaseClient(
        interceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        val client: OkHttpClient =
            OkHttpClient.Builder().addInterceptor(interceptor)
                .callTimeout(ApiConstant.API_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(ApiConstant.API_TIMEOUT, TimeUnit.SECONDS)
                .connectTimeout(ApiConstant.API_TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true).build()
        return client
    }

    @Provides
    @Singleton
    fun provideBaseRetrofit(
        okHttpClient: OkHttpClient,
        gsonFactory: GsonConverterFactory,
    ): Retrofit {
        return Retrofit.Builder().baseUrl(ApiConstant.BASE_URL).client(okHttpClient)
            .addConverterFactory(gsonFactory).build()
    }

    @Provides
    @Singleton
    fun provideHomeApiService(retrofit: Retrofit): HomeService {
        return retrofit.create(HomeService::class.java)
    }
}