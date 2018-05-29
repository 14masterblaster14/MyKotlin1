package com.example.admin.mykotlin1.di

import com.example.admin.mykotlin1.MainActivityModule
import com.example.admin.mykotlin1.viewmodel.ViewModelBuilder
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by ADMIN on 5/26/2018.
 */

@Singleton
//@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class])
@Component(modules = arrayOf(AndroidSupportInjectionModule::class
        , AppModule::class
        , ViewModelBuilder::class
        , MainActivityModule::class))

interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}