package com.panichmaxim.alphastrah.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.panichmaxim.alphastrah.R;

public class PoliciesFragment extends Fragment {


    public PoliciesFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_policies, container, false);
    }

}
