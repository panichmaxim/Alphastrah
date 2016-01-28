package com.panichmaxim.alphastrah.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment;
import com.panichmaxim.alphastrah.R;
import com.panichmaxim.alphastrah.model.network.insurance.Insurance;
import com.panichmaxim.alphastrah.presenter.InsurancesPresenter;
import com.panichmaxim.alphastrah.view.InsurancesView;
import java.util.ArrayList;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;


public class InsurancesFragment extends MvpLceFragment<SwipeRefreshLayout, List<Insurance>, InsurancesView, InsurancesPresenter> implements InsurancesView, SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.recyclerView) RecyclerView recyclerView;
    private InsurancesAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_insurances_list, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstance) {
        super.onViewCreated(view, savedInstance);
        ButterKnife.bind(this, view);
        contentView.setOnRefreshListener(this);
        adapter = new InsurancesAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        loadData(false);
    }

    @Override
    public void loadData(boolean pullToRefresh) {
        presenter.loadCountries(pullToRefresh);
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
    public void setData(List<Insurance> data) {
        adapter.setData(data);
        adapter.notifyDataSetChanged();
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

    private class InsurancesAdapter extends RecyclerView.Adapter<InsurancesAdapter.ViewHolder> {

        private List<Insurance> nodes = new ArrayList<>();

        public class ViewHolder extends RecyclerView.ViewHolder {

            private TextView title;
            private TextView property;

            public ViewHolder(View itemView) {
                super(itemView);
                title = (TextView) itemView.findViewById(R.id.title);
                property = (TextView) itemView.findViewById(R.id.property);
            }

        }

        // http://stackoverflow.com/questions/24885223/why-doesnt-recyclerview-have-onitemclicklistener-and-how-recyclerview-is-dif
        private class MyOnClickListener implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                //
            }
        }

        public void setData(List<Insurance> nodes) {
            this.nodes = nodes;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_insurance, parent, false);
            v.setOnClickListener(new MyOnClickListener());
            return new ViewHolder(v);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.title.setText(this.nodes.get(position).getTitle());
            holder.property.setText(this.nodes.get(position).getInsuredObject());
        }

        @Override
        public int getItemCount() {
            return this.nodes.size();
        }
    }
}
