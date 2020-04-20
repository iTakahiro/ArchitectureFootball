package io.github.itakahiro.architecturefootball.feature.playcall

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.github.itakahiro.architecturefootball.R

class PlayCallListFragment: Fragment() {

    val viewModel =
        PlayCallListViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_play_call_list, container, false)
    }
}