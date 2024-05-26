package com.example.quipperandroidtest.ModuleProvider

import com.example.quipperandroidtest.Repositories.PlaylistDataRepository
import com.example.quipperandroidtest.Service.PlaylistDataService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://quipper.github.io/native-technical-exam/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideVideoApiService(retrofit: Retrofit): PlaylistDataService {
        return retrofit.create(PlaylistDataService::class.java)
    }

    @Provides
    @Singleton
    fun provideVideoRepository(apiService: PlaylistDataService): PlaylistDataRepository {
        return PlaylistDataRepository(apiService)
    }
}