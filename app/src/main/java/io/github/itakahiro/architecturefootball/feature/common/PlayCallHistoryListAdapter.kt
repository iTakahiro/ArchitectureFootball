package io.github.itakahiro.architecturefootball.feature.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import io.github.itakahiro.architecturefootball.R
import io.github.itakahiro.architecturefootball.model.PlayCall

class PlayCallHistoryListAdapter(
    fragment: Fragment,
    viewModel: PlayCallHistoryListViewModel
) : RecyclerView.Adapter<PlayCallHistoryListAdapter.ViewHolder>() {
    init {
        viewModel.playCallHistoryList.observe(fragment, Observer { historyList ->
            setItems(historyList)
        })
    }

    private val items = mutableListOf<PlayCall>()

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_hitory_list, parent, false)
        return ViewHolder(
            inflater
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position].description
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<View>(R.id.textViewHistoryItem) as TextView
    }

    private fun setItems(items: List<PlayCall>) {
        this.items.clear()
        items.forEach { item ->
            this.items.add(item)
        }
        notifyDataSetChanged()
    }
}