package com.example.myapplication11.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;

import com.example.myapplication11.R;
import com.example.myapplication11.config.LoadState;
import com.example.myapplication11.databinding.FragmentBaseBinding;
import com.example.myapplication11.databinding.ViewLoadErrorBinding;
import com.example.myapplication11.databinding.ViewLoadingBinding;
import com.example.myapplication11.databinding.ViewNoDataBinding;
import com.example.myapplication11.databinding.ViewNoNetworkBinding;

import com.example.myapplication11.manager.MyActivityManager;
import com.example.myapplication11.ui.activity.login.LoginActivity;
import com.example.myapplication11.ui.activity.main.MainActivity;
import com.example.myapplication11.ui.activity.main.MainViewModel;

public abstract class BaseFragment<DB extends ViewDataBinding, VM extends BaseViewModel> extends Fragment {
    protected DB mDataBinding;
    protected VM mViewModel;

    private FragmentBaseBinding mFragmentBaseBinding;
    private ViewLoadingBinding mViewLoadingBinding;
    private ViewLoadErrorBinding mViewLoadErrorBinding;
    private ViewNoNetworkBinding mViewNoNetworkBinding;
    private ViewNoDataBinding mViewNoDataBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            handleArguments(args);
        }
        initViewModel();
        if (mViewModel != null) {
            getLifecycle().addObserver(mViewModel);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mFragmentBaseBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_base, container, false);
        mDataBinding = DataBindingUtil.inflate(inflater,
                getLayoutResId(), mFragmentBaseBinding.flContentContainer, true);

        bindViewModel();
        mDataBinding.setLifecycleOwner(this);
        initLoadState();
        initCollectState();
        init();
        return mFragmentBaseBinding.getRoot();
    }

    private void initLoadState() {
        if (mViewModel != null && isSupportLoad()) {
            mViewModel.loadState.observe(getViewLifecycleOwner(), new Observer<LoadState>() {
                @Override
                public void onChanged(LoadState loadState) {
                    switchLoadView(loadState);
                }
            });
            Activity activity = MyActivityManager.getsInstance().getCurrentActivity();
            if (activity instanceof MainActivity) {
                ((MainActivity) activity).mDataBinding.fabTop.setVisibility(View.VISIBLE);
            }
        } else {
            Activity activity = MyActivityManager.getsInstance().getCurrentActivity();
            if (activity instanceof MainActivity) {
                ((MainActivity) activity).mDataBinding.fabTop.setVisibility(View.GONE);
            }
        }
    }


    private void switchLoadView(LoadState loadState) {
        removeLoadView();

        switch (loadState) {
            case LOADING:
                if (mViewLoadingBinding == null) {
                    mViewLoadingBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.view_loading,
                            mFragmentBaseBinding.flContentContainer, false);
                }
                mFragmentBaseBinding.flContentContainer.addView(mViewLoadingBinding.getRoot());
                break;

            case NO_NETWORK:
                if (mViewNoNetworkBinding == null) {
                    mViewNoNetworkBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.view_no_network,
                            mFragmentBaseBinding.flContentContainer, false);
                    mViewNoNetworkBinding.setViewModel(mViewModel);
                }
                mFragmentBaseBinding.flContentContainer.addView(mViewNoNetworkBinding.getRoot());
                break;

            case NO_DATA:
                if (mViewNoDataBinding == null) {
                    mViewNoDataBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.view_no_data,
                            mFragmentBaseBinding.flContentContainer, false);
                }
                mFragmentBaseBinding.flContentContainer.addView(mViewNoDataBinding.getRoot());
                break;

            case ERROR:
                if (mViewLoadErrorBinding == null) {
                    mViewLoadErrorBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.view_load_error,
                            mFragmentBaseBinding.flContentContainer, false);
                    mViewLoadErrorBinding.setViewModel(mViewModel);
                }
                mFragmentBaseBinding.flContentContainer.addView(mViewLoadErrorBinding.getRoot());
                break;

            default:
                break;
        }
    }

    private void removeLoadView() {
        int childCount = mFragmentBaseBinding.flContentContainer.getChildCount();
        if (childCount > 1) {
            mFragmentBaseBinding.flContentContainer.removeViews(1, childCount - 1);
        }
    }


    private void initCollectState() {
        if (mViewModel == null) {
            return;
        }
        mViewModel.getCollect().observe(getViewLifecycleOwner(), new Observer<Object>() {
            @Override
            public void onChanged(Object collect) {
                if (collect == null) {
                    //跳转到登录界面
//                    LoginActivity.start(getActivity());
                }
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mViewModel != null) {
            getLifecycle().removeObserver(mViewModel);
        }
        removeLoadView();
    }


    /**
     * 处理参数
     *
     * @param args 参数容器
     */
    protected void handleArguments(Bundle args) {

    }


    /**
     * 是否支持页面加载。默认不支持
     *
     * @return true表示支持，false表示不支持
     */
    protected boolean isSupportLoad() {
        return false;
    }

    /**
     * 获取当前页面的布局资源ID
     *
     * @return 布局资源ID
     */
    protected abstract int getLayoutResId();

    /**
     * 初始化ViewModel
     */
    protected abstract void initViewModel();

    /**
     * 绑定ViewModel
     */
    protected abstract void bindViewModel();

    /**
     * 初始化
     */
    protected abstract void init();

}
