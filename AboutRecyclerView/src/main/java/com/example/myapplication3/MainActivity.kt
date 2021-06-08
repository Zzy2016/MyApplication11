package com.example.myapplication3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        resources.getStringArray(R.array.array)
        var list = resources.getStringArray(R.array.array)
        rv.adapter=FlowerAdapter(list)
    }
}

class FlowerAdapter(var list: Array<String>) : RecyclerView.Adapter<FlowerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


    /*
    * ViewHolder 负责存储RecyclerView中每一个单独的表项所需显式的信息。
    * RecyclerView只需要创建当前所显示的表项数量的ViewHolder外加存储中的几个ViewHolder即可
    * 随着用户的滑动屏幕，ViewHolder会被回收，（）使用新数据填充），已有的表项会在一端小时，并且在另一端显示一个新的表项
    * adapter从数据源获取数据，并将数据传递给正在更新其所持有试图的ViewHolder
    *
    * */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //        constructor(itemView: View) : super(itemView)
        val tv: TextView = itemView.findViewById(R.id.tvItem)
        fun bind(text: String) {
            tv.text = text
        }
    }
}