package io.github.itakahiro.architecturefootball.feature.football

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.itakahiro.architecturefootball.R


class HistoryListAdapter() : RecyclerView.Adapter<HistoryListAdapter.ViewHolder>() {
    // TODO: String -> PlayCall
    private val items = mutableListOf<String>()

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_hitory_list, parent, false)
        return ViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position]
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView = itemView.findViewById<View>(R.id.textViewHistoryItem) as TextView
    }

    // TODO: String -> PlayCall
    fun setItem(item: String) {
        items.add(item)
    }
}