package com.example.admin.mykotlin1.di

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by ADMIN on 5/26/2018.
 */
@Module
class AppModule {

    @Provides
    fun providesContext(application: App): Context {
        return application.applicationContext
    }
}