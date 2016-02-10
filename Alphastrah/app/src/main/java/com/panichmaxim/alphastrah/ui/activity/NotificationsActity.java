package com.panichmaxim.alphastrah.ui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.panichmaxim.alphastrah.R;
import com.panichmaxim.alphastrah.controller.adapter.NotificationsListAdapter;
import com.panichmaxim.alphastrah.controller.db.DBFactory;
import com.panichmaxim.alphastrah.model.network.notification.NWNotification;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NotificationsActity extends AppCompatActivity {

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private NotificationsListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        ButterKnife.bind(this);
        String id = getIntent().getStringExtra("id");
        ArrayList<NWNotification> sortedNotifications = new ArrayList<>();
        for (NWNotification node : DBFactory.create().getNotificationEndpoint().getItems()) {
            if (id.equals(node.getInsuranceId()))  sortedNotifications.add(node);
        }
        mAdapter = new NotificationsListAdapter();
        mAdapter.setData(sortedNotifications);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
