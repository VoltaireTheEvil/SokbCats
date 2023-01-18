package ru.niisokb.makulin.sokbcats.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.niisokb.makulin.sokbcats.data.retrofit.CatsApiService
import ru.niisokb.makulin.sokbcats.di.annotations.CatApiKeyQualifier
import javax.inject.Singleton

const val API_HEADER_API_KEY = "x-api-key"
const val CATS_API_BASE_URL = "https://api.thecatapi.com/v1/"

@Module
class NetworkModule {

    @[Provides Singleton]
    fun providesCatsApiService(retrofit: Retrofit): CatsApiService = retrofit.create()

    @[Provides Singleton]
    fun providesGson(): Gson = GsonBuilder().create()

    @[Provides Singleton]
    fun providesOkHttpClient(@CatApiKeyQualifier apiKey: String): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val authorizedRequest = chain.request().newBuilder()
                    .addHeader(API_HEADER_API_KEY, apiKey)
                    .build()
                chain.proceed(authorizedRequest)
            }
            .build()

    @[Provides Singleton]
    fun providesRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(CATS_API_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

}