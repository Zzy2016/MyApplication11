package com.example.nav2.ui.home

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

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("Fragment","Home   onCreate")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("Fragment","Home   onAttach")
    }

    override fun onStart() {
        super.onStart()
        Log.e("Fragment","Home   onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("Fragment","Home   onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Fragment","Home   onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("Fragment","Home   onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Fragment","Home   onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("Fragment","Home   onDestroyView")
    }
    
}