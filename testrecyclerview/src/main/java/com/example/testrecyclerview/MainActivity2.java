package com.example.testrecyclerview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Service;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {


    RecyclerView rv;
    List list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rv = findViewById(R.id.rv);


        for (int i = 0; i < 88; i++) {
            list.add(i + "  ");
        }

//        TestAdapter testAdapter=new TestAdapter();
//        testAdapter.submitList(list);
//
//        rv.setAdapter(testAdapter);
        CustomAdapter adapter = new CustomAdapter(list);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new GridLayoutManager(this,2));
        helper.attachToRecyclerView(rv);
    }

    ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.Callback() {

        String TAG = "Helper-->";
        private int startPosition;
        private int toPosition;


        @Override
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            int dragFlag = 0;
//            if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
//                dragFlag = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
//            } else if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
//                dragFlag = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
//            }
            dragFlag = ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;

            return makeMovementFlags(dragFlag, 0);
//            //允许上下的拖动
//            int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
//            //只允许从右向左侧滑
//            int swipeFlags = ItemTouchHelper.LEFT;
//            return makeMovementFlags(dragFlags, swipeFlags);

//            该方法返回一个Flags表示Item的三种状态状态：idle(空闲)、 swiping(滑动)、dragging(拖动)，
        }

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            Log.e(TAG, "onMove");
//            当 ItemTouchHelper 拖动一个Item时该方法将会被回调，Item将从旧的位置移动到新的位置
////                    * 如果不拖动这个方法将从来不会调用,返回true表示已经被移动到新的位置

            startPosition=viewHolder.getAdapterPosition();
            toPosition=target.getAdapterPosition();
            Log.e("moving----",startPosition+"    "+toPosition);

            int formPosition = viewHolder.getAdapterPosition();
            int toPosition = target.getAdapterPosition();

            if (formPosition < target.getAdapterPosition()) {
                for (int i = formPosition; i < toPosition; i++) {
                    Collections.swap(list, i, i + 1);
                }
            } else {
                for (int i = formPosition; i > toPosition; i--) {
                    Collections.swap(list, i, i - 1);
                }
            }
            Log.e(TAG, "clearView1" + list);
            recyclerView.getAdapter().notifyItemMoved(formPosition, toPosition);
            return true;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            Log.e(TAG, "onSwiped");
//            当Item被滑动的时候被调用
//                    * 如果你不滑动这个方法将不会被调用
        }

        @Override
        public boolean isLongPressDragEnabled() {
            Log.e(TAG, "isLongPressDragEnabled");
            return true;

        }

        @Override
        public boolean isItemViewSwipeEnabled() {
            return true;
        }


//        当item由静止状态变为滑动或拖动状态时调用此方法
        @Override
        public void onSelectedChanged(@Nullable RecyclerView.ViewHolder viewHolder, int actionState) {
            super.onSelectedChanged(viewHolder, actionState);
            Log.e(TAG, "onSelectedChanged   " + actionState);
            if (actionState != ItemTouchHelper.ACTION_STATE_IDLE) {
                Vibrator vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
                vibrator.vibrate(100);
            }
        }

        @Override
        public void clearView(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            super.clearView(recyclerView, viewHolder);
//            Log.e(TAG, "clearView" + startPosition+   "    "+toPosition);

//            String temp= list.get(toPosition).toString();
//            list.set(toPosition,list.get(startPosition));
//            list.set(startPosition,temp);
//
//            recyclerView.getAdapter().notifyItemRangeChanged(startPosition,toPosition);
//            startPosition=0;
//            toPosition=0;


            recyclerView.getAdapter().notifyDataSetChanged();
        }

        @Override
        public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        }
    });

    class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

        List<String> list;

        public CustomAdapter(List<String> list) {
            this.list = list;
            Log.e("CustomAdapter--->","CustomAdapter");
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Log.e("CustomAdapter--->","onCreateViewHolder");
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            Log.e("CustomAdapter--->","onBindViewHolder"+position);
            holder.tv.setText(list.get(position) + " ");
            holder.tvDelete.setText(position + " ");
        }

        @Override
        public int getItemCount() {
            Log.e("CustomAdapter--->","getItemCount");
            return list.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            public TextView tv, tvDelete, tvInsert;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tv = itemView.findViewById(R.id.tvItem);
                tvDelete = itemView.findViewById(R.id.tvDelete);
                tvInsert = itemView.findViewById(R.id.tvInsert);
            }
        }
    }


//    class  TestAdapter extends ListAdapter<String, TestAdapter.ViewHolder>{
//
//
//        public TestAdapter() {
//            super(new DiffUtil.ItemCallback<String>() {
//                @Override
//                public boolean areItemsTheSame(@NonNull String oldItem, @NonNull String newItem) {
//                    return oldItem==newItem;
//                }
//
//                @Override
//                public boolean areContentsTheSame(@NonNull String oldItem, @NonNull String newItem) {
//                    return oldItem.equals(newItem);
//                }
//            });
//        }
//
//        @NonNull
//        @Override
//        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
//            return new ViewHolder(view);
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//            holder.tv.setText(position+" ");
//
//            holder.tvDelete.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//
//                }
//            });
//        }
//
//        class ViewHolder extends RecyclerView.ViewHolder{
//            public TextView tv,tvDelete,tvInsert;
//
//            public ViewHolder(@NonNull View itemView) {
//                super(itemView);
//                tv=itemView.findViewById(R.id.tvItem);
//                tvDelete=itemView.findViewById(R.id.tvDelete);
//                tvInsert=itemView.findViewById(R.id.tvInsert);
//            }
//        }
//    }

}