package com.panichmaxim.alphastrah.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.panichmaxim.alphastrah.R;
import com.panichmaxim.alphastrah.ui.utils.FontTextView;
import com.panichmaxim.alphastrah.utils.SimpleStorage;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AccountActivity extends BaseActivity {

    @Bind(R.id.fio_textview) FontTextView mFioTextView;
    @Bind(R.id.phone_textview) FontTextView mPhoneTextView;
    @Bind(R.id.email_textview) FontTextView mEmailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        ButterKnife.bind(this);
        mFioTextView.setText(SimpleStorage.getInstance().getAccount().getLastName() + " " + SimpleStorage.getInstance().getAccount().getFirstName() + " " + SimpleStorage.getInstance().getAccount().getPatronymic());
        mPhoneTextView.setText(SimpleStorage.getInstance().getAccount().getPhone().getForHuman());
        mEmailTextView.setText(SimpleStorage.getInstance().getAccount().getEmail());
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
