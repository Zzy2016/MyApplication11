package com.example.share

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFRagment=supportFragmentManager.findFragmentById(R.id.menu1_fragment) as NavHostFragment
        val nav=navHostFRagment.navController


    }
}
