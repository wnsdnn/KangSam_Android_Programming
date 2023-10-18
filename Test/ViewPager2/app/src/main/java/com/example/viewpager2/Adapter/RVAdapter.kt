package com.example.viewpager2.Adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpager2.R

class RVAdapter(val items: MutableList<String>): RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        val intent = LayoutInflater.from(parent?.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(intent)
    }

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        holder.itemBinding(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun itemBinding(text: String) {
            val layout_text = itemView.findViewById<TextView>(R.id.layout_text)
            layout_text.text = text

            when(position % 3) {
                0 -> layout_text.setBackgroundColor(Color.RED)
                1 -> layout_text.setBackgroundColor(Color.BLUE)
                2 -> layout_text.setBackgroundColor(Color.GREEN)
            }
        }
    }
}