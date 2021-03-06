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
import com.example.appkotlin.LoadState
import com.example.appkotlin.MyApplication
import com.example.appkotlin.R
import com.example.appkotlin.base.BaseFragment
import com.example.appkotlin.bean.BannerBean
import com.example.appkotlin.bean.Data
import com.example.appkotlin.databinding.FragmentHomeBinding
import com.example.appkotlin.net.RetrofitManager
import com.zhouwei.mzbanner.holder.MZHolderCreator
import com.zhouwei.mzbanner.holder.MZViewHolder
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Retrofit


class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {


    override fun getResLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initViewModel() {
        Log.e("home","initViewModel")
        mViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
//        initDataChange()
    }

    override fun bindViewModel() {
        Log.e("home","bindViewModel")


        mDataBinding.image.setOnClickListener { TODO("Not yet implemented") }


//        mViewModel.mutableBanner.observe(this, Observer { bannerBean ->
//            mzBanner.setPages(bannerBean.data as List<Nothing>?, MZHolderCreator<BannerViewHolder>
//            { return@MZHolderCreator BannerViewHolder() })
//        })

        mViewModel.mutableBanner.observe(viewLifecycleOwner, object: Observer<BannerBean>{
            override fun onChanged(t: BannerBean?) {

            }
        })



    }


    suspend fun text(){
        Log.e("banner",RetrofitManager.getService().loadProjectTree().data.toString());
    }

    override fun init() {
        Log.e("home","init")
        mViewModel.loadData()
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


