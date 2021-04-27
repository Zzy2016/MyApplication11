package com.example.test1launchmode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

/*
* recyclerview item删除
* TextView文字分散对齐
*
* */
class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var list= List(20){"item ---> $it" }

        println(list)

        var adapter=RvAdapter(list)
        rv.adapter=adapter
        var hint="“劳动节”即将来临，公司按照国asdaq1家2021年劳动节放假统一安11排ads，休息时间为2021年5月1日至2021年5月5日，共计5天，4月25日，5月8日上班；节日期间建议大家减少外出，做好安全防疫工作，祝大家节日快乐！"
        tv.text=hint

        tv1.text=hint

        tv2.text=toDbc(hint)

    }

    private fun toDbc(str:String):String{
        var a=str.toCharArray()
        for((index,item) in a.withIndex()){
            if(item.toInt()==12288){
                a[index]=32.toChar()
                continue
            }
            if(a[index].toInt() in 65290..65374){
//                a[index]=(a[index].toInt()-65248) as Char
//                var b:Char=a[index].toInt()-65248 as
                a[index]=(a[index].toInt()-65248).toChar()
            }
        }
        return String(a)
    }
}