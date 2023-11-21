package com.example.dailymotiontest.presentation.di

import android.content.Context
import android.content.res.Resources
import com.example.dailymotiontest.presentation.formatter.VideoCreationTimeFormatter
import com.example.dailymotiontest.presentation.formatter.VideoCreationTimeFormatterImpl
import com.example.dailymotiontest.presentation.mapper.VideosMapper
import com.example.dailymotiontest.presentation.mapper.VideosMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import java.time.Clock

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideClock() = Clock.systemDefaultZone()

    @Provides
    @ViewModelScoped
    fun provideResources(@ApplicationContext appContext: Context) = appContext.resources

    @Provides
    @ViewModelScoped
    fun provideFormatter(clock: Clock, resources: Resources): VideoCreationTimeFormatter =
        VideoCreationTimeFormatterImpl(clock, resources)

    @Provides
    @ViewModelScoped
    fun provideMapper(formatter: VideoCreationTimeFormatter): VideosMapper =
        VideosMapperImpl(formatter)
}