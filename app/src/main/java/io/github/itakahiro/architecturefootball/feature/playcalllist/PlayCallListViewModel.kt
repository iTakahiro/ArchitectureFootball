package io.github.itakahiro.architecturefootball.feature.playcalllist

import io.github.itakahiro.architecturefootball.feature.common.PlayCallHistoryListViewModel
import io.github.itakahiro.architecturefootball.model.PlayCall
import io.github.itakahiro.architecturefootball.repository.PlayCallRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PlayCallListViewModel(
    private val repository: PlayCallRepository
) : PlayCallHistoryListViewModel() {
    // TODO: viewModelJobいらんかも? このクラスはViewModel()を継承してないから
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
                repository.loadAllPlayCall().forEach { playCall ->
                    playCallMutableList.add(PlayCall(description = playCall.description))
                }
            }
            setPlayCallHistoryList(playCallMutableList)
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
