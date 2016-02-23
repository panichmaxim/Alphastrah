package com.panichmaxim.alphastrah.ui.fragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment;
import com.panichmaxim.alphastrah.R;
import com.panichmaxim.alphastrah.controller.adapter.InsurancesListAdapter;
import com.panichmaxim.alphastrah.controller.adapter.SimpleSectionedRecyclerViewAdapter;
import com.panichmaxim.alphastrah.model.utils.InsurancesListData;
import com.panichmaxim.alphastrah.presenter.InsurancesPresenter;
import com.panichmaxim.alphastrah.ui.activity.NotificationsActivity;
import com.panichmaxim.alphastrah.ui.activity.SendEmailActivity;
import com.panichmaxim.alphastrah.ui.view.InsurancesView;
import com.redmadrobot.chronos.ChronosConnector;

public class InsurancesFragment extends MvpLceFragment<SwipeRefreshLayout, InsurancesListData, InsurancesView, InsurancesPresenter> implements InsurancesView, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    private InsurancesListAdapter mAdapter;
    private SimpleSectionedRecyclerViewAdapter mSectionedAdapter;
    private ChronosConnector mConnector = new ChronosConnector();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_insurances_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);
        mConnector.onCreate(getPresenter(), savedInstance);
        ButterKnife.bind(this, view);
        contentView.setOnRefreshListener(this);
        mAdapter = new InsurancesListAdapter(mRecyclerView, getActivity());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // Adding sections
        mSectionedAdapter = new SimpleSectionedRecyclerViewAdapter(getActivity(),R.layout.section,R.id.section_text, mAdapter);
        mRecyclerView.setAdapter(mSectionedAdapter);
        loadData(false);
    }

    @Override
    public void onResume() {
        super.onResume();
        mConnector.onResume();
    }

    @Override
    public void onSaveInstanceState(@NonNull final Bundle outState) {
        super.onSaveInstanceState(outState);
        mConnector.onSaveInstanceState(outState);
    }

    @Override
    public void onPause() {
        super.onPause();
        mConnector.onPause();
    }

    @OnClick(R.id.fab)
    public void fabButtonClick() {
        getActivity().startActivity(new Intent(getActivity(), SendEmailActivity.class));
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        presenter.loadData(pullToRefresh, mConnector);
    }

    @Override
    public void onRefresh() {
        loadData(true);
    }

    @Override
    public InsurancesPresenter createPresenter() {
        return new InsurancesPresenter();
    }

    @Override
    public void setData(InsurancesListData insurancesInfo) {
        mSectionedAdapter.setSections(insurancesInfo.sortAndGetSections());
        mAdapter.setData(insurancesInfo);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showContent() {
        super.showContent();
        contentView.setRefreshing(false);
    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return null;
    }

    @Override
    public void showError(Throwable e, boolean pullToRefresh) {
        super.showError(e, pullToRefresh);
        contentView.setRefreshing(false);
    }

    @Override
    public void showLoading(boolean pullToRefresh) {
        super.showLoading(pullToRefresh);
        contentView.setRefreshing(pullToRefresh);
    }

}
