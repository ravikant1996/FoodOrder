package com.example.project1kotlin.di

import android.content.Context
import androidx.room.Room
import com.example.lifecycleaware.retrofitseriesmvvm.roomdb.FoodDatabase
import com.example.project1kotlin.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModuleRoom {

    @Singleton // Tell Dagger-Hilt to create a singleton accessible everywhere in Application Component (i.e. everywhere in the application)
    @Provides
    fun provideYourDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        FoodDatabase::class.java,
        "orderDB"
    ).build() // The reason we can construct a database for the repo

    @Singleton
    @Provides
    fun provideYourDao(db: FoodDatabase) = db.foodDao()
    // The reason we can implement a Dao for the database
}