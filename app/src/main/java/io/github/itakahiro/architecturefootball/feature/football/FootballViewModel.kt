package io.github.itakahiro.architecturefootball.feature.football

import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.itakahiro.architecturefootball.Application
import io.github.itakahiro.architecturefootball.data.PlayCallEntity
import io.github.itakahiro.architecturefootball.data.db.PlayCallDao
import io.github.itakahiro.architecturefootball.model.PlayCall

class FootballViewModel {
    private val dao = Application.playCallDatabase.playCallDao()

    private val _submittedText =
        MutableLiveData<String>().also { mutableLiveData ->
            mutableLiveData.value = "ここに、出力されます"
        }
    val submittedText: LiveData<String>
        get() = _submittedText

    private val _isEnabled: MutableLiveData<Boolean> =
        MutableLiveData<Boolean>().also { mutableLiveData ->
            mutableLiveData.value = false
        }
    val isEnabled: LiveData<Boolean>
        get() = _isEnabled

    private val _buttonText: MutableLiveData<String> =
        MutableLiveData<String>().also { mutableLiveData ->
            mutableLiveData.value = "Ready"
        }
    val buttonText: LiveData<String>
        get() = _buttonText

    private val _playCallHistoryList: MutableLiveData<List<PlayCall>> =
        MutableLiveData<List<PlayCall>>().also { mutableLiveData ->
            mutableLiveData.value = emptyList()
        }
    val playCallHistoryList: LiveData<List<PlayCall>>
        get() = _playCallHistoryList

    fun setPlayCallHistoryList(historyList: List<PlayCall>) {
        _playCallHistoryList.value = historyList
    }

    fun updateButton(isBlank: Boolean) {
        _isEnabled.value = !isBlank

        if (!isBlank) {
            _buttonText.value = "Set!!!"
        } else {
            _buttonText.value = "Ready"
        }
    }

    fun submitText(text: String) {
        _submittedText.value = text
    }

    fun loadPlayCallHistoryList() {
        val asyncLoad = AsyncLoad(dao, this)
        asyncLoad.execute()
    }

    fun savePlayCall(playCall: PlayCall) {
        val asyncSave = AsyncSave(dao)
        asyncSave.execute(playCall)
    }
}

// Coroutinesを使いたい
class AsyncLoad(private val dao: PlayCallDao, private val viewModel: FootballViewModel) : AsyncTask<Void, Void, List<PlayCall>>() {

    override fun onPreExecute() {}

    override fun doInBackground(vararg voids: Void): List<PlayCall>? {
        val playCallMutableList = mutableListOf<PlayCall>()
        dao.loadAllPlayCall().forEach { playCall ->
            playCallMutableList.add(PlayCall(description = playCall.description))
        }
        return playCallMutableList
    }

    override fun onPostExecute(listOfPlayCalls: List<PlayCall>) {
        viewModel.setPlayCallHistoryList(listOfPlayCalls)
    }
}

class AsyncSave(private val dao: PlayCallDao) : AsyncTask<PlayCall, PlayCall, Void>() {

    override fun onPreExecute() {}

    override fun doInBackground(vararg playCall: PlayCall): Void? {
        dao.savePlayCall(PlayCallEntity(description = playCall.first().description))
        return null
    }

    override fun onPostExecute(result: Void?) {}
}