package com.panichmaxim.alphastrah.ui.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import com.panichmaxim.alphastrah.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SendEmailActivity extends AppCompatActivity {

    @Bind(R.id.subject) EditText mSubjectView;
    @Bind(R.id.body) EditText mBodyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);
        ButterKnife.bind(this);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @OnClick(R.id.send_button)
    public void signInButtonClicked(){
        mSubjectView.setError(null);
        mBodyView.setError(null);
        String subject = mSubjectView.getText().toString();
        String body = mBodyView.getText().toString();
        boolean cancel = false;
        View focusView = null;
        if (TextUtils.isEmpty(body)) {
            mBodyView.setError(getString(R.string.error_field_required));
            focusView = mBodyView;
            cancel = true;
        }
        if (TextUtils.isEmpty(subject)) {
            mSubjectView.setError(getString(R.string.error_field_required));
            focusView = mSubjectView;
            cancel = true;
        }
        if (cancel) {
            focusView.requestFocus();
        } else {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts( "mailto", "maxim6665@yandex.ru", null));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
            emailIntent.putExtra(Intent.EXTRA_TEXT, body);
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
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
