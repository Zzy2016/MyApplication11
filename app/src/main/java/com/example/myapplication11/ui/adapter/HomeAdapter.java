package com.example.myapplication11.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.myapplication11.BR;
import com.example.myapplication11.R;
import com.example.myapplication11.bean.responsebean.ArticleBean;
import com.example.myapplication11.bean.responsebean.home.HomeData;

import java.util.List;

import static com.example.myapplication11.config.App.getContext;

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<HomeData> mList;

    public HomeAdapter() {
    }

    /**
     * 添加监听回调
     *
     * @param root
     * @param itemData
     * @param position
     */
    public void addListener(View root, HomeData itemData, int position) {
    }

    /**
     * 添加监听回调
     *
     * @param itemData
     */
    public void addTopClickListener(ArticleBean itemData) {
    }
    /**
     * 添加监听回调
     *
     * @param itemData
     */
    public void addTopCollectListener(ArticleBean itemData) {
    }



    /**
     * 改变数据
     *
     * @param newItemDatas
     */
    public void onItemDatasChanged(List<HomeData> newItemDatas) {
        this.mList = newItemDatas;
        notifyDataSetChanged();
    }

    public int getItemLayout(HomeData itemData) {
        if (itemData.getBannerData() != null) {
            return R.layout.item_home_banner;
        } else if (itemData.getTopArticleList() != null) {
            return R.layout.item_home_top;
        } else {
            return R.layout.item_article;
        }
    }


    @Override
    public int getItemViewType(int position) {
        return getItemLayout(mList.get(position));
    }


    @NonNull
    @Override
    public CommonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), viewType, parent, false);
        return new CommonViewHolder(dataBinding);
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        HomeData homeData = mList.get(position);
        if(homeData.getArticleList()!=null){
            ((CommonViewHolder) holder).binding.setVariable(BR.articleBean, homeData.getArticleList());
        }else if(homeData.getTopArticleList() != null){
            ((CommonViewHolder) holder).binding.setVariable(BR.topArticle, homeData.getTopArticleList());
            showTopArticle(((CommonViewHolder) holder).binding.getRoot().findViewById(R.id.recycler_view),homeData.getTopArticleList());
        }else{
            ((CommonViewHolder) holder).binding.setVariable(BR.bannerData, homeData.getBannerData());
        }
        addListener(((CommonViewHolder) holder).binding.getRoot(), mList.get(position), position);
        //防止数据闪烁
        ((CommonViewHolder) holder).binding.executePendingBindings();
    }

    private void showTopArticle(RecyclerView recyclerView, HomeData.TopArticle topArticle){

        CommonAdapter commonAdapter = new CommonAdapter<ArticleBean>(topArticle.getArticleBeanList(),R.layout.item_article, BR.articleBean) {
            @Override
            public void addListener(View root, ArticleBean itemData, int position) {
                super.addListener(root, itemData, position);
                root.findViewById(R.id.card_view).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        addTopClickListener(itemData);
                    }
                });

                root.findViewById(R.id.iv_collect).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        itemData.setCollect(!itemData.isCollect());
                        notifyDataSetChanged();
                        addTopCollectListener(itemData);
//                        mViewModel.changeArticleCollect(itemData.isCollect(), itemData.getId());
                    }
                });
            }
        };
        recyclerView.setAdapter(commonAdapter);

        StaggeredGridLayoutManager layoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
//        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }
}
