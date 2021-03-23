package com.example.appkotlin.activity.ui.home

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.appkotlin.MyApplication
import com.example.appkotlin.R
import com.example.appkotlin.base.BaseFragment
import com.example.appkotlin.bean.Data
import com.example.appkotlin.databinding.FragmentHomeBinding
import com.zhouwei.mzbanner.holder.MZHolderCreator
import com.zhouwei.mzbanner.holder.MZViewHolder
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {


    override fun getResLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initViewModel() {
        mViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

    }

    override fun bindViewModel() {
//        mDataBinding.viewModel = mViewModel
//        mViewModel.loadState.postValue(LoadState.LOADING)

        mViewModel.loadData()

        mViewModel.mutableBanner.observe(this, Observer { bannerBean ->
            mzBanner.setPages(bannerBean.data as List<Nothing>?, MZHolderCreator<BannerViewHolder> { return@MZHolderCreator BannerViewHolder() })
        })


    }

    override fun init() {
    }


    class BannerViewHolder() : MZViewHolder<Data> {

        lateinit var imageView: ImageView

        override fun createView(p0: Context?): View {
            var view = LayoutInflater.from(p0).inflate(R.layout.item_banner, null)
            imageView = view.findViewById(R.id.img)
            return view
        }

        override fun onBind(context: Context?, p1: Int, data: Data?) {
            if (context != null) {
                Log.e("1--", "0" + (data?.imagePath));
                Glide.with(context).load(data?.imagePath).into(imageView)
            } else {
                Log.e("1--", "1");
            }
        }

    }


}


