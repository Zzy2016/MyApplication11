package com.example.myapplication.page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.MainActivity2;
import com.example.myapplication.MainActivity3;
import com.example.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment1 extends Fragment {

    private BlankFragment1 instance;

    private boolean isResume = false;
    private boolean isVisible = false;

    private TextView textView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment1() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment1 newInstance(String param1, String param2) {
        BlankFragment1 fragment = new BlankFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.e("Fragment", "Fragment1  onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        instance = this;
        Log.e("Fragment", "Fragment1  onCreate");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("Fragment", "Fragment1  onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("Fragment", "Fragment1  onResume");
//        textView.setText(System.currentTimeMillis() + "  Fragment1 onResume");
        isResume = true;
        refreshUI();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("Fragment", "Fragment1  onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("Fragment", "Fragment1  onStop");
        isResume=false;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("Fragment", "Fragment1  onDestroy");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.e("Fragment", "Fragment1  onCreateView");
        View view = inflater.inflate(R.layout.fragment_blank1, container, false);
        textView = view.findViewById(R.id.tv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity2.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("Fragment", "Fragment1  onDetach");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("Fragment", "Fragment1  onDestroyView");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e("Fragment", "Fragment1  onHiddenChanged");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.e("Fragment", "Fragment1  setUserVisibleHint  -->" + isVisibleToUser);
//        if(isVisibleToUser){
////            new Handler().postDelayed(new Runnable() {
////                @Override
////                public void run() {
////                    textView.setText(System.currentTimeMillis() + "  Fragment1 setUserVisibleHint");
////                }
////            },100);
//            if(textView==null){
//                Log.e("Fragment", "Fragment1  getUserVisibleHint  -->  null ");
//            }else{
//                textView.setText(System.currentTimeMillis() + "  Fragment1 setUserVisibleHint");
//            }
//
////            textView.setText(System.currentTimeMillis() + "  Fragment1 setUserVisibleHint");
//        }
        if (isVisibleToUser) {
            isVisible = true;
            refreshUI();
        } else {
            isVisible = false;
        }
    }

    private void refreshUI() {
        if (isVisible && isResume) {
            textView.setText("System   "+System.currentTimeMillis());
        }
    }

    @Override
    public boolean getUserVisibleHint() {
        Log.e("Fragment", "Fragment1  getUserVisibleHint  -->" + super.getUserVisibleHint());
        return super.getUserVisibleHint();
    }
}