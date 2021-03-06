package com.panichmaxim.alphastrah.controller.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.panichmaxim.alphastrah.R;
import com.panichmaxim.alphastrah.model.utils.InsurancesListData;
import com.panichmaxim.alphastrah.ui.activity.NotificationsActivity;

public class InsurancesListAdapter extends RecyclerView.Adapter<InsurancesListAdapter.ViewHolder> {

    public InsurancesListData mNodes = new InsurancesListData();
    private RecyclerView mRecyclerView;
    private Context context;

    public InsurancesListAdapter(RecyclerView mRecyclerView, Context context) {
        this.mRecyclerView = mRecyclerView;
        this.context = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitle;
        private TextView mProperty;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title);
            mProperty = (TextView) itemView.findViewById(R.id.property);
        }

    }

    // http://stackoverflow.com/questions/24885223/why-doesnt-recyclerview-have-onitemclicklistener-and-how-recyclerview-is-dif
    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, NotificationsActivity.class);
            intent.putExtra("id", mNodes.getmInsurancesData().get(((SimpleSectionedRecyclerViewAdapter) mRecyclerView.getAdapter()).sectionedPositionToPosition(mRecyclerView.indexOfChild(v))).getId());
            context.startActivity(intent);
        }
    }

    public void setData(InsurancesListData nodes) {
        this.mNodes = nodes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_insurance, parent, false);
        v.setOnClickListener(new MyOnClickListener());
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTitle.setText(this.mNodes.getmInsurancesData().get(position).getTitle());
        holder.mProperty.setText(this.mNodes.getmInsurancesData().get(position).getInsuredObject());
    }

    @Override
    public int getItemCount() {
        return this.mNodes.getmInsurancesData().size();
    }
}
