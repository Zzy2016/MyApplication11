package com.example.kot

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlin.coroutines.coroutineContext

class ForeAdapter(val items: List<String>) : RecyclerView.Adapter<ForeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tv.text = items[position]



    }

    override fun getItemCount(): Int {
        return items.size
    }

    //参数前需要加上 val var
    class ViewHolder(val tv: TextView) : RecyclerView.ViewHolder(tv)
}


