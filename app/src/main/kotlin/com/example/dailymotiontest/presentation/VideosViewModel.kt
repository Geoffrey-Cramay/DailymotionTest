package com.example.dailymotiontest.presentation

import com.example.dailymotiontest.presentation.VideoViewData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.dailymotiontest.core.VideosInteractor
import com.example.dailymotiontest.presentation.mapper.VideosMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideosViewModel @Inject constructor(
    private val interactor: VideosInteractor,
    private val mapper: VideosMapper,
) : ViewModel() {
    private val _mutableState =
        MutableStateFlow<PagingData<VideoViewData>>(value = PagingData.empty())
    val state: StateFlow<PagingData<VideoViewData>> get() = _mutableState

    fun load() {
        viewModelScope.launch {
            interactor.getVideos()
                .cachedIn(viewModelScope)
//                .onStart { _mutableState.update { VideosListViewState.Loading } }
//                .catch { exception ->
//                    Log.w(TAG, exception)
//                    _mutableState.update { VideosListViewState.Error }
//                }
                .collect { videoList ->

                    _mutableState.update {
                        videoList.map { video -> mapper.map(video) }
                    }
                }
        }
    }

    companion object {
        private const val TAG = "videos_view_model"
    }
}