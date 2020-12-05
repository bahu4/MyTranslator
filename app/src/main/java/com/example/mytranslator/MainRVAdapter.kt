package com.example.mytranslator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainRVAdapter : RecyclerView.Adapter<MainRVAdapter.ViewHolder>() {
    private var list = listOf("a", "b", "c", "d", "e", "f", "g",)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.main_rv_item, parent, false)
        )


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val word = itemView.findViewById<TextView>(R.id.word)
        private val description = itemView.findViewById<TextView>(R.id.description)
        fun bind(position: String) {
            if (layoutPosition != RecyclerView.NO_POSITION) {
                word.text = position
                description.text = position
            }
        }
    }
}