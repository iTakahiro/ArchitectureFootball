package io.github.itakahiro.architecturefootball.feature.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.itakahiro.architecturefootball.model.PlayCall

open class PlayCallHistoryListViewModel {
    private val _playCallHistoryList: MutableLiveData<List<PlayCall>> =
        MutableLiveData<List<PlayCall>>().also { mutableLiveData ->
            mutableLiveData.value = emptyList()
        }
    val playCallHistoryList: LiveData<List<PlayCall>>
        get() = _playCallHistoryList

    fun setPlayCallHistoryList(historyList: List<PlayCall>) {
        _playCallHistoryList.value = historyList
    }
}
