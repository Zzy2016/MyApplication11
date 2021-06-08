package com.example.appkotlin.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.appkotlin.LoadState
import com.example.appkotlin.R
import com.example.appkotlin.databinding.*


abstract class BaseFragment<DM : ViewDataBinding, VM : BaseViewModel> : Fragment() {

    lateinit var mDataBinding: DM
    lateinit var mViewModel: VM

    lateinit var baseBinding: FragmentBaseBinding
    lateinit var noDataBinding: ItemNodataBinding
    lateinit var noNetBinding: ItemNonetBinding
    lateinit var loadingBinding: ItemLoadingBinding
    lateinit var loadErrorBinding: ItemErrorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewModel()
        this.lifecycle.addObserver(mViewModel)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        baseBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_base, container, false)

        mDataBinding = DataBindingUtil.inflate(inflater, getResLayoutId(), baseBinding.flContent, true)
        bindViewModel()
        mDataBinding.lifecycleOwner = this
        initLoadState()

        init()
        return baseBinding.root
    }


    private fun initLoadState() {
        if (mViewModel != null) {
//            mViewModel.loadState.observe(viewLifecycleOwner, Observer<LoadState> { t: LoadState? ->
//                if (t != null) {
//                    Log.e("LoadState--->B1", "    " + t)
//                    switchLoadState(t)
//                }B
//            })
            mViewModel.loadState.observe(viewLifecycleOwner, Observer<LoadState>{
                Log.e("LoadState--->B1-",""+it);
            })
        }
        Log.e("LoadState--->B",""+"Observer");


    }


    private fun switchLoadState(loadState: LoadState) {

        removeLoading()

        Log.e("LoadState--->B", "    " + loadState)
        when (loadState) {
            LoadState.LOADING -> {
                if (!::loadingBinding.isInitialized || loadingBinding == null) {
                    loadingBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_loading, baseBinding.flContent, false);
                }
                baseBinding.flContent.addView(loadingBinding.root)
            }

            LoadState.NO_DATA -> {
                if (!::noDataBinding.isInitialized || noDataBinding == null) {
                    noDataBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_nodata, baseBinding.flContent, false)
                }
                baseBinding.flContent.addView(noDataBinding.root)
            }
            LoadState.NO_NETWORK -> {
                if (!::noNetBinding.isInitialized || noNetBinding == null) {
                    noNetBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_nonet, baseBinding.flContent, false)
                }
                baseBinding.flContent.addView(noNetBinding.root)
            }
            LoadState.LOAD_ERROR -> {
                if (!::loadErrorBinding.isInitialized || loadErrorBinding == null) {
                    loadErrorBinding = DataBindingUtil.inflate(layoutInflater, R.layout.item_error, baseBinding.flContent, false)
                }
                baseBinding.flContent.addView(loadErrorBinding.root)
            }
        }
    }

    fun removeLoading() {
        var childCount = baseBinding.flContent.childCount
        if (childCount > 1) {
            baseBinding.flContent.removeViews(1, childCount - 1)
        }
    }


    //获取当前  布局ID
    abstract fun getResLayoutId(): Int


    //实例化ViewModel
    abstract fun initViewModel()


    //绑定viewModel
    abstract fun bindViewModel()

    abstract fun init()

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment BaseFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//                BaseFragment().apply {
//                    arguments = Bundle().apply {
//                        putString(ARG_PARAM1, param1)
//                        putString(ARG_PARAM2, param2)
//                    }
//                }
//    }
}


