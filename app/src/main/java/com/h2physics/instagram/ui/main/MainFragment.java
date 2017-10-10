package com.h2physics.instagram.ui.main;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.h2physics.instagram.R;
import com.h2physics.instagram.data.model.Photo;
import com.h2physics.instagram.data.remote.Callback;
import com.h2physics.instagram.data.remote.manager.NetworkManagement;
import com.h2physics.instagram.ui.adapter.PhotoAdapter;
import com.h2physics.instagram.ui.base.BaseFragment;
import com.h2physics.instagram.utils.SnackbarUtils;

import java.util.List;

import butterknife.BindView;

/**
 * Created by YukiNoHara on 10/8/2017.
 */

public class MainFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener{
    private static final String LOG_TAG = MainFragment.class.getSimpleName();
    @BindView(R.id.refresher)
    SwipeRefreshLayout mRefresher;
    @BindView(R.id.rv_photo)
    RecyclerView mRvPhoto;

    private PhotoAdapter mAdapter;
    private NetworkManagement mNetwork;

    @Override
    public int getContentLayout() {
        return R.layout.fragment_main;
    }

    @Override
    public void initView(View view) {
        mRvPhoto.addItemDecoration(new ItemDecoration(getActivity().getDrawable(R.drawable.divider)));
        Log.e(LOG_TAG, "InitView");
    }

    @Override
    public void initData() {
        mAdapter = new PhotoAdapter(getActivity());
        mNetwork = new NetworkManagement(getActivity()).getInstance(getActivity());
        mRefresher.setOnRefreshListener(this);
        fetchData();

    }

    private void fetchData(){
        mNetwork.getPhotos(mContext, new Callback<List<Photo>>() {
            @Override
            public void onSuccess(List<Photo> photos) {
                Log.e(LOG_TAG, "OnSuccess");
                mAdapter.addAll(photos);
                mRvPhoto.setAdapter(mAdapter);
            }

            @Override
            public void onFailed() {
                Log.e(LOG_TAG, "OnFailed");
                SnackbarUtils.getInstance(getView(), "Failed to get photos");
            }
        });
    }

    @Override
    public void onRefresh() {
        fetchData();
        mRefresher.setRefreshing(false);
    }
}
