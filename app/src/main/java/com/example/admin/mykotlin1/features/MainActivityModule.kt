package com.example.admin.mykotlin1

import android.arch.lifecycle.ViewModel
import com.example.a243208.mykotlintry.MainViewModel
import com.example.admin.mykotlin1.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

/**
 * Created by ADMIN on 5/26/2018.
 */
@Module
internal abstract class MainActivityModule {

    @ContributesAndroidInjector()
    internal abstract fun mainActivity(): MainActivity

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

}