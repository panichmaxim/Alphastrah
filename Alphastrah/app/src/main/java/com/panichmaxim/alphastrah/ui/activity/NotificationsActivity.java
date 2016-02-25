package com.panichmaxim.alphastrah.ui.activity;

import butterknife.Bind;
import butterknife.ButterKnife;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.panichmaxim.alphastrah.R;
import com.panichmaxim.alphastrah.controller.adapter.NotificationsListAdapter;
import com.panichmaxim.alphastrah.controller.db.DBFactory;
import com.panichmaxim.alphastrah.controller.operations.GetNotifications;
import com.panichmaxim.alphastrah.model.network.notification.NWNotification;
import com.redmadrobot.chronos.ChronosConnector;

import java.util.ArrayList;

public class NotificationsActivity extends BaseActivity {

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    private NotificationsListAdapter mAdapter;
    private ChronosConnector mConnector = new ChronosConnector();
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
        ButterKnife.bind(this);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mConnector.onCreate(this, savedInstanceState);
        pd = ProgressDialog.show(this, null, getString(R.string.title_loading), true, false);
        mConnector.runOperation(new GetNotifications(), false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mConnector.onResume();
    }

    @Override
    protected void onSaveInstanceState(@NonNull final Bundle outState) {
        super.onSaveInstanceState(outState);
        mConnector.onSaveInstanceState(outState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mConnector.onPause();
    }

    public void onOperationFinished(final GetNotifications.Result result) {
        pd.dismiss();
        if (result.isSuccessful()) {
            String id = getIntent().getStringExtra("id");
            ArrayList<NWNotification> sortedNotifications = new ArrayList<>();
            for (NWNotification node : DBFactory.create().getNotificationEndpoint().getItems()) {
                if (id.equals(node.getInsuranceId()))  sortedNotifications.add(node);
            }
            mAdapter = new NotificationsListAdapter();
            mAdapter.setData(sortedNotifications);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerView.setAdapter(mAdapter);
        } else {
            Toast.makeText(this, getString(R.string.data_load_error), Toast.LENGTH_SHORT).show();
        }
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
