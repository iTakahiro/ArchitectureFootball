package io.github.itakahiro.architecturefootball.feature.playcall

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.itakahiro.architecturefootball.R
import io.github.itakahiro.architecturefootball.feature.football.FootballViewModel
import io.github.itakahiro.architecturefootball.feature.football.PlayCallHistoryListAdapter
import kotlinx.android.synthetic.main.fragment_play_call_list.playCallList

class PlayCallListFragment: Fragment() {

    private val viewModel = FootballViewModel()

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
            PlayCallHistoryListAdapter(
                this,
                viewModel
            )
        playCallList.adapter = adapter
        playCallList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        viewModel.loadPlayCallHistoryList()
    }
}
