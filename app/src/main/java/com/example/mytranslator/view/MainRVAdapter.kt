package com.example.mytranslator.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mytranslator.R
import com.example.mytranslator.data.SearchResult

class MainRVAdapter(private var data: List<SearchResult>) :
    RecyclerView.Adapter<MainRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.main_rv_item, parent, false)
        )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val word = itemView.findViewById<TextView>(R.id.word)
        private val description = itemView.findViewById<TextView>(R.id.description)
        fun bind(data: SearchResult) {
            if (layoutPosition != RecyclerView.NO_POSITION) {
                word.text = data.text
                description.text = data.meanings?.get(0)?.translation?.translation
            }
        }
    }
}