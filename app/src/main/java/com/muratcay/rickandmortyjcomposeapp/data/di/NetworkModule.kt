package com.muratcay.rickandmortyjcomposeapp.data.di

import android.content.Context
import com.muratcay.rickandmortyjcomposeapp.BuildConfig
import com.muratcay.rickandmortyjcomposeapp.data.remote.api.CharacterService
import com.muratcay.rickandmortyjcomposeapp.data.remote.repository.CharacterRepository
import com.muratcay.rickandmortyjcomposeapp.data.remote.repository.impl.CharacterRepositoryImpl
import com.muratcay.rickandmortyjcomposeapp.utils.AppConstant.CONNECT_TIMEOUT
import com.muratcay.rickandmortyjcomposeapp.utils.AppConstant.READ_TIMEOUT
import com.muratcay.rickandmortyjcomposeapp.utils.AppConstant.WRITE_TIMEOUT
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
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(provideGsonConverterFactory())
            .build()
    }

    @Provides
    fun provideCharacterService(retrofit: Retrofit): CharacterService {
        return retrofit.create(CharacterService::class.java)
    }

    @Provides
    fun provideCharacterRepository(characterService: CharacterService): CharacterRepository {
        return CharacterRepositoryImpl(characterService)
    }
}