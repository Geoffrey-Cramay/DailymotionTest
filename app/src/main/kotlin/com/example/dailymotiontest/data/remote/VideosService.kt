package com.example.dailymotiontest.data.remote

import com.example.dailymotiontest.data.remote.model.VideosResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface VideosService {
    @GET("videos")
    suspend fun getVideos(
        @Query("fields") fields: String = "thumbnail_url,channel.created_time,title,description,id,owner,embed_url",
        @Query("page") page: Int,
        @Query("limit") limit: Int,
    ): VideosResponse
}