package com.example.dailymotiontest.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.dailymotiontest.core.model.Video
import com.example.dailymotiontest.data.remote.VideoRemoteService
import com.example.dailymotiontest.data.repository.parser.VideosParser

class VideoPagingDataSource(
    private val remoteService: VideoRemoteService,
    private val parser: VideosParser
) : PagingSource<Int, Video>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Video> {
        return try {
            val currentPage = params.key ?: 1
            val response = remoteService.getVideos(currentPage, params.loadSize)
            LoadResult.Page(
                data = parser.parse(response.list),
                prevKey = null,
                nextKey = if (response.has_more) {
                    currentPage + (params.loadSize / LIMIT)
                } else {
                    null
                }
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Video>): Int? {
        return state.anchorPosition
    }

    companion object {
        const val LIMIT = 10
    }
}