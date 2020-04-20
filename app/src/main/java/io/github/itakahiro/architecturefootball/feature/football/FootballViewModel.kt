package io.github.itakahiro.architecturefootball.feature.football

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.itakahiro.architecturefootball.Application
import io.github.itakahiro.architecturefootball.data.PlayCallEntity
import io.github.itakahiro.architecturefootball.model.PlayCall
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FootballViewModel {
    private val dao = Application.database.playCallDao()

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

    private fun setPlayCallHistoryList(historyList: List<PlayCall>) {
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

    /**
     * This is the job for all coroutines started by this ViewModel.
     * Cancelling this job will cancel all coroutines started by this ViewModel.
     */
    private val viewModelJob = SupervisorJob()

    /**
     * This is the main scope for all coroutines launched by MainViewModel.
     * Since we pass viewModelJob, you can cancel all coroutines
     * launched by uiScope by calling viewModelJob.cancel()
     */
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun loadPlayCallHistoryList() {
        // AsyncTaskを用いた場合
//        val asyncLoad = AsyncLoad(dao, this)
//        asyncLoad.execute()
        val playCallMutableList = mutableListOf<PlayCall>()
        uiScope.launch {
            withContext(Dispatchers.Default) {
                dao.loadAllPlayCall().forEach { playCall ->
                    playCallMutableList.add(PlayCall(description = playCall.description))
                }
            }
            setPlayCallHistoryList(playCallMutableList)
        }
    }

    fun savePlayCall(playCall: PlayCall) {
        // AsyncTaskを用いた場合
//        val asyncSave = AsyncSave(dao, this)
//        asyncSave.execute(playCall)
        uiScope.launch {
            withContext(Dispatchers.Default) {
                dao.savePlayCall(PlayCallEntity(description = playCall.description))
            }
            loadPlayCallHistoryList()
        }
    }
}

// AsyncTaskを用いた場合
//class AsyncLoad(private val dao: PlayCallDao, private val viewModel: FootballViewModel) : AsyncTask<Void, Void, List<PlayCall>>() {
//
//    override fun onPreExecute() {}
//
//    override fun doInBackground(vararg voids: Void): List<PlayCall>? {
//        val playCallMutableList = mutableListOf<PlayCall>()
//        dao.loadAllPlayCall().forEach { playCall ->
//            playCallMutableList.add(PlayCall(description = playCall.description))
//        }
//        return playCallMutableList
//    }
//
//    override fun onPostExecute(listOfPlayCalls: List<PlayCall>) {
//        viewModel.setPlayCallHistoryList(listOfPlayCalls)
//    }
//}
//
//class AsyncSave(private val dao: PlayCallDao, private val viewModel: FootballViewModel) : AsyncTask<PlayCall, PlayCall, Void>() {
//
//    override fun onPreExecute() {}
//
//    override fun doInBackground(vararg playCall: PlayCall): Void? {
//        dao.savePlayCall(PlayCallEntity(description = playCall.first().description))
//        return null
//    }
//
//    override fun onPostExecute(result: Void?) {
//        val asyncLoad = AsyncLoad(dao, viewModel)
//        asyncLoad.execute()
//    }
//}
