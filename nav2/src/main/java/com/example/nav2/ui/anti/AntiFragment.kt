package com.example.nav2.ui.anti

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.nav2.R

class AntiFragment : Fragment() {

    private lateinit var dashboardViewModel: AntiViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProviders.of(this).get(AntiViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_anti, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("Fragment","Dash   onCreate")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("Fragment","Dash   onAttach")
    }

    override fun onStart() {
        super.onStart()
        Log.e("Fragment","Dash   onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("Fragment","Dash   onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Fragment","Dash   onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("Fragment","Dash   onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Fragment","Dash   onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("Fragment","Dash   onDestroyView")
    }
    
}