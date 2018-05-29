package com.example.admin.mykotlin1.di

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * Created by ADMIN on 5/26/2018.
 */
class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

        return DaggerAppComponent.builder().create(this)
    }
}