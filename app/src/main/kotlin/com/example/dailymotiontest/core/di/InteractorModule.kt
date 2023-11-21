package com.example.dailymotiontest.core.di

import com.example.dailymotiontest.core.VideosInteractor
import com.example.dailymotiontest.core.VideosInteractorImpl
import com.example.dailymotiontest.core.VideosRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object InteractorModule {

    @Provides
    @ViewModelScoped
    fun provideInteractor(repository: VideosRepository): VideosInteractor =
        VideosInteractorImpl(repository)
}