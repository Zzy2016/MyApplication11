package com.example.httptestj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.example.httptestj.databinding.ItemListBinding;

import java.util.List;

import static com.example.httptestj.BR.user;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<User> list;

    public ItemAdapter(List<User> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_list, parent, false);
        return new ItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.getBinding().setVariable(user, list.get(position));
        holder.binding.executePendingBindings();

        ItemListBinding itemListBinding= (ItemListBinding) holder.binding;


        holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                notifyDataSetChanged();//刷新全部数据
//                notifyItemChanged(index);//刷新指定的item
//                notifyItemRangeChanged(indexStart,indexEnd);//刷新指定位置的item 局部刷新指定数据
//                notifyItemInserted(index);//插入指定位置item 并刷新
//                notifyItemMoved(index);//移动指定位置item 并刷新
//                notifyItemRemoved(index);//删除指定位置item 并刷新



                //正常有删除动画
//                list.remove(position);
//                notifyItemRemoved(position);
//                notifyItemRangeChanged(position,list.size()-1);

                //直接删除无动画
//                list.remove(position);
//                notifyDataSetChanged();


//                notifyItemRemoved(position);
//                notifyItemRangeChanged(position,list.size()-1);
//                notifyItemRangeChanged(position,getItemCount());
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        public ViewDataBinding binding;

        public ItemViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public ViewDataBinding getBinding() {
            return binding;
        }

        public void setBinding(ViewDataBinding binding) {
            this.binding = binding;
        }
    }
}
