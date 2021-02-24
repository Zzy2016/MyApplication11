package com.example.nav2.ui.doctor

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

class DoctorFragment : Fragment() {

    private lateinit var notificationsViewModel: DoctorViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProviders.of(this).get(DoctorViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_doctor, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("Fragment","Notification   onCreate")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("Fragment","Notification   onAttach")
    }

    override fun onStart() {
        super.onStart()
        Log.e("Fragment","Notification   onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("Fragment","Notification   onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.e("Fragment","Notification   onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.e("Fragment","Notification   onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("Fragment","Notification   onDestroy")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("Fragment","Notification   onDestroyView")
    }

}