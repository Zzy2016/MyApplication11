package com.example.test1launchmode

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RvAdapter(list: List<String>) : RecyclerView.Adapter<RvAdapter.RvViewHolder>() {

    var list = mutableListOf<String>()

    init {
        this.list = list as MutableList<String>
    }


    class RvViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvItemContent: TextView = itemView.findViewById(R.id.tvItemContent)
        var tvDelete: TextView = itemView.findViewById(R.id.tvDelete)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false);
        return RvViewHolder(view)
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        holder.tvItemContent.text = list[position] + "   $position"
        holder.tvDelete.setOnClickListener {
            Log.e("删除---》", "   " + list[position] + "  $position")
//            list.removeAt(position)
//            notifyDataSetChanged()

            list.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, list.size - position)
//            positionStart 要删除的item position
//            itemCount  从positionStart到数据列表最后
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


    /*
    * 删除item 没有动画效果
    * list.removeAt(position)
    * notifyDataSetChanged()
    *
    *
    * notifyItemRemoved(position)
    * 单独使用，index会错乱，没有刷新item,position也没有刷新，item保留的position还是以前的position
    * 删除第一个之后，第二个成为第一个，但是position还是1，点击删除第二个，会删除列表的position。
    *
    *
    * list.removeAt(position)
    * notifyItemRemoved(position) 显示动画效果  省略这个 数组越界
    * notifyItemRangeChanged(position,list.size-position) 对于删除掉的位置以及其后range大小范围内的view进行重新onBindViewHolder
    *positionStart 要删除的item position
    * itemCount  从positionStart到数据列表最后
    * */


}