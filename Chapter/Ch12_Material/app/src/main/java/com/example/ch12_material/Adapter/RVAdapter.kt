package com.example.ch12_material.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ch12_material.R

class RVAdapter(val items: MutableList<String>): RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        val intent = LayoutInflater.from(parent?.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(intent)
    }

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        holder.itemBinding(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun itemBinding(item: String) {
            val itemText = itemView.findViewById<TextView>(R.id.itemText)
            itemText.text = item
        }
    }

}