package com.example.dailymotiontest.data.repository.di

import com.example.dailymotiontest.core.VideosRepository
import com.example.dailymotiontest.data.remote.VideoRemoteService
import com.example.dailymotiontest.data.remote.VideoVideoRemoteServiceImpl
import com.example.dailymotiontest.data.remote.VideosService
import com.example.dailymotiontest.data.repository.VideosRepositoryImpl
import com.example.dailymotiontest.data.repository.parser.VideosParser
import com.example.dailymotiontest.data.repository.parser.VideosParserImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideRemoteService(service: VideosService): VideoRemoteService =
        VideoVideoRemoteServiceImpl(service)

    @Provides
    @ViewModelScoped
    fun provideSongsParser(): VideosParser = VideosParserImpl

    @Provides
    @ViewModelScoped
    fun provideSongsRepository(
        service: VideoRemoteService,
        parser: VideosParser,
    ): VideosRepository = VideosRepositoryImpl(service, parser)
}