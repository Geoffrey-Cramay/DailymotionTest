package com.example.dailymotiontest.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dailymotiontest.core.VideosInteractor
import com.example.dailymotiontest.presentation.mapper.VideosMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideosViewModel @Inject constructor(
    private val interactor: VideosInteractor,
    private val mapper: VideosMapper,
) : ViewModel() {
    private val _mutableState = MutableStateFlow<VideosListViewState>(VideosListViewState.Loading)
    val state: StateFlow<VideosListViewState> get() = _mutableState

    fun load() {
        viewModelScope.launch {
            interactor.getVideos()
                .onStart { _mutableState.update { VideosListViewState.Loading } }
                .catch { exception ->
                    Log.w(TAG, exception)
                    _mutableState.update { VideosListViewState.Error }
                }.collect { videoList ->
                    _mutableState.update {
                        val a = 0
                        VideosListViewState.Success(videoList = videoList.map { video ->
                            mapper.map(video)
                        })
                    }
                }
        }
    }

    companion object {
        private const val TAG = "videos_view_model"
    }
}