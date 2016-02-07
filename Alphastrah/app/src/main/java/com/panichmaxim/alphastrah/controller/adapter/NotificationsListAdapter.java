package com.panichmaxim.alphastrah.controller.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.panichmaxim.alphastrah.R;
import com.panichmaxim.alphastrah.model.db.notification.Notification;
import com.panichmaxim.alphastrah.model.network.notification.NWNotification;

import java.util.ArrayList;
import java.util.List;

public class NotificationsListAdapter extends RecyclerView.Adapter<NotificationsListAdapter.ViewHolder> {
    private List<Notification> mNodes = new ArrayList<>();

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitle;
        private TextView mDescription;

        public ViewHolder(View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.title);
            mDescription = (TextView) itemView.findViewById(R.id.description);
        }

    }

    public void setData(List<Notification> nodes) {
        this.mNodes = nodes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_notification, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTitle.setText(this.mNodes.get(position).getmTitle());
        holder.mDescription.setText(this.mNodes.get(position).getmShortDescription());
    }

    @Override
    public int getItemCount() {
        return this.mNodes.size();
    }
}
