package com.panichmaxim.alphastrah.controller.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.panichmaxim.alphastrah.R;
import com.panichmaxim.alphastrah.model.network.insurance.Insurance;
import java.util.ArrayList;
import java.util.List;

public class InsuranceListAdapter extends RecyclerView.Adapter<InsuranceListAdapter.ViewHolder> {

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
