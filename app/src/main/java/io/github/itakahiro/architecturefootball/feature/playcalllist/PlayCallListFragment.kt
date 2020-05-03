package io.github.itakahiro.architecturefootball.feature.playcalllist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.itakahiro.architecturefootball.R
import io.github.itakahiro.architecturefootball.feature.common.PlayCallHistoryListAdapter
import io.github.itakahiro.architecturefootball.feature.playcalllist.di.inject
import kotlinx.android.synthetic.main.fragment_play_call_list.playCallList
import javax.inject.Inject

class PlayCallListFragment : Fragment() {

    // DIすることで、以下3行を消せる. つまりこれらのクラスに対する依存性を軽減できる.
//    private val dao = App.database.playCallDao()
//    private val repository = PlayCallRepository(dao)
//    private val viewModel = PlayCallListViewModel(repository)
    @Inject
    lateinit var viewModel: PlayCallListViewModel

    override fun onAttach(context: Context) {
//        App.appComponent.inject(this)
        this.inject()
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_play_call_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter =
            PlayCallHistoryListAdapter(this, viewModel)
        playCallList.adapter = adapter
        playCallList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        viewModel.loadPlayCallHistoryList()
    }
}
