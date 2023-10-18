package com.example.ch12_material.Fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ch12_material.Adapter.RVAdapter
import com.example.ch12_material.Adapter.RVDecoration
import com.example.ch12_material.R
import com.example.ch12_material.databinding.FragmentOneBinding


class OneFragment : Fragment() {

    lateinit var binding: FragmentOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_one, container, false)

        val itemList = mutableListOf<String>()
        for (i in 1..20) {
            itemList.add("item $i")
        }

        val rv = binding.rv
        rv.adapter = RVAdapter(itemList)
        rv.layoutManager = LinearLayoutManager(activity)
        rv.addItemDecoration(RVDecoration(activity as Context))



        return binding.root
    }

}