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
//https://api.dailymotion.com/videos
// ?fields=thumbnail_url%2Cchannel.created_time%2Ctitle%2Cdescription%2Cid%2Cowner%2Cembed_url
// &page=1&limit=10&context=
