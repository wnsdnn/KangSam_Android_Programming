package com.example.ch13_activity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val items: MutableList<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val intent = LayoutInflater.from(parent?.context).inflate(R.layout.item_recyclerview, parent, false)

        return ViewHolder(intent)
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        holder.itemBinding(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun itemBinding(item: String) {
            val itemData = itemView.findViewById<TextView>(R.id.item_data)
            itemData.text = item
        }
    }
}
