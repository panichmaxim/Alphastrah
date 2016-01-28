package com.panichmaxim.alphastrah.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.panichmaxim.alphastrah.R;
import com.panichmaxim.alphastrah.ui.utils.FontTextView;
import com.panichmaxim.alphastrah.utils.SimpleStorage;
import butterknife.Bind;
import butterknife.ButterKnife;


public class AccountFragment extends Fragment {

    @Bind(R.id.fio_textview) FontTextView fioTextView;
    @Bind(R.id.phone_textview) FontTextView phoneTextView;
    @Bind(R.id.email_textview) FontTextView emailTextView;

    public AccountFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_account, container, false);
        ButterKnife.bind(this, rootView);
        fioTextView.setText(SimpleStorage.getInstance().getAccount().getLastName() + " " + SimpleStorage.getInstance().getAccount().getFirstName() + " " + SimpleStorage.getInstance().getAccount().getPatronymic());
        phoneTextView.setText(SimpleStorage.getInstance().getAccount().getPhone().getForHuman());
        emailTextView.setText(SimpleStorage.getInstance().getAccount().getEmail());
        return rootView;
    }

}
