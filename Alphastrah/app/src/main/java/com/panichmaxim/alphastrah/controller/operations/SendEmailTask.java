package com.panichmaxim.alphastrah.controller.operations;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.panichmaxim.alphastrah.App;
import com.panichmaxim.alphastrah.utils.GMailSender;

public class SendEmailTask extends AsyncTask<Void, Void, Void> {

    private ProgressDialog pd;
    private String subject;
    private String body;
    private Context ctx;

    public SendEmailTask(String subject, String body, Context ctx) {
        this.subject = subject;
        this.body = body;
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        pd = ProgressDialog.show(ctx, null, "Загрузка", true, false);
    }

    @Override
    protected Void doInBackground(Void... arg0) {
        try {
            GMailSender sender = new GMailSender("****", "****");
            sender.sendMail(subject,
                    body,
                    "***");
        } catch (Exception e) {
            Log.e("SendMail", e.getMessage(), e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        pd.dismiss();
    }

}
