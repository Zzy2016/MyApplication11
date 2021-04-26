package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.PopupMenu
import com.google.android.material.snackbar.Snackbar

class MainActivity6 : AppCompatActivity() {

    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

//        var toolbar=supportActionBar
//        if (toolbar != null) {
//            toolbar.hide()
//        }

        btn = findViewById(R.id.btnShowMenu)
//        btn.setOnClickListener(fun(v: View) {
//            val popup = PopupMenu(this, v)
//            val inflater: MenuInflater = popup.menuInflater
//            inflater.inflate(R.menu.home_bottom, popup.menu)
//            popup.show()
//        })

//        btn.setOnClickListener{
//            val popup = PopupMenu(this, it)
//            val inflater: MenuInflater = popup.menuInflater
//            inflater.inflate(R.menu.home_bottom, popup.menu)
//            popup.show()
//        }
        registerForContextMenu(btn)







    }



//    var a={
//       v:View->
//        val popup = PopupMenu(this, v)
//        val inflater: MenuInflater = popup.menuInflater
//        inflater.inflate(R.menu.home_bottom, popup.menu)
//        popup.show()
//        null
//    }

//    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
////        super.onCreateContextMenu(menu, v, menuInfo)
//        var inflater:MenuInflater=menuInflater
//        inflater.inflate(R.menu.menu1,menu)
//
//    }


    //选项菜单
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        var inflater = menuInflater
//        inflater.inflate(R.menu.menu1, menu)
//        return true
//    }
//
//
//    //选项菜单点击事件
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when (item.itemId) {
//            R.id.item1 -> {
//                Log.e("选项菜单", "item  ")
//                true
//            }
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
//
//    override fun onOptionsMenuClosed(menu: Menu?) {
//        super.onOptionsMenuClosed(menu)
//        Log.e("选项菜单", "onOptionsMenuClosed")
//    }
//
//    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
//        Log.e("选项菜单", "onPrepareOptionsMenu")
////        menu?.clear()
//        invalidateOptionsMenu() //清空onPrepareOptionMenu
//        var inflater=menuInflater
//        inflater.inflate(R.menu.home_bottom,menu)
//        return true
//    }
//
    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
//        super.onCreateContextMenu(menu, v, menuInfo)

           var inflater=menuInflater
        inflater.inflate(R.menu.menu1,menu)

    }

}

