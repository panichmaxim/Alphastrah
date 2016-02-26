package com.panichmaxim.alphastrah.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import com.panichmaxim.alphastrah.R;
import com.panichmaxim.alphastrah.ui.fragment.InsurancesFragment;
import com.panichmaxim.alphastrah.ui.utils.AnimationController;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MenuActivity extends BaseActivity implements View.OnClickListener {

    @Bind(R.id.drawer_layout) DrawerLayout mDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(toggle);
        toggle.syncState();

        findViewById(R.id.profile_fragment).setOnClickListener(this);
        findViewById(R.id.policies_fragment).setOnClickListener(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new InsurancesFragment()).commit();
            setTitle(getString(R.string.title_policies));
        }
    }

    @Override
    public void onBackPressed() {
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        mDrawer.closeDrawer(GravityCompat.START);
        switch(v.getId()) {
            case R.id.profile_fragment:
                startActivity(new Intent(this, AccountActivity.class));
                break;
            case R.id.policies_fragment:
                AnimationController.makeTransaction(getSupportFragmentManager().beginTransaction().replace(R.id.container, new InsurancesFragment()));
                setTitle(getString(R.string.title_policies));
                break;
        }
    }
}
