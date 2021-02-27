package com.example.helpyouout.adapter

import android.content.Context
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.helpyouout.R
import com.example.helpyouout.model.HomeMenuModel

class HomeMenuAdapter(val context: Context, val listOfData: ArrayList<HomeMenuModel>) : RecyclerView.Adapter<HomeMenuAdapter.VH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(context).inflate(R.layout.home_grid_view, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        var data = listOfData[position];

    }

    class VH(itemview: View) : RecyclerView.ViewHolder(itemview)

    override fun getItemCount(): Int {
        return listOfData.size
    }

}