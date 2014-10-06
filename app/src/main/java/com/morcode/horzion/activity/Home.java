package com.morcode.horzion.activity;

import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.morcode.horzion.App;
import com.morcode.horzion.R;

import com.morcode.horzion.screen.ScreenManager;
import com.morcode.horzion.screen.fragment.HomeFragment;
import com.morcode.horzion.ui.OffCanvas;

import javax.inject.Inject;

public class Home extends ActionBarActivity {

    private OffCanvas offcanvas;

    @Inject
    ScreenManager screenManager;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((App) getApplication()).inject(this);

        screenManager.setFragmentManager(getFragmentManager());
        screenManager.addFragment("home", new HomeFragment());

        setContentView(R.layout.activity_home);

        offcanvas = (OffCanvas) findViewById(R.id.offcanvas);
        offcanvas.initComponents(this);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        if (offcanvas.getActionBarDrawerToggle().onOptionsItemSelected(item)) return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle (CharSequence title) {
        getActionBar().setTitle(title);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        offcanvas.getActionBarDrawerToggle().syncState();
    }

    @Override
    public void onConfigurationChanged (Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        offcanvas.getActionBarDrawerToggle().onConfigurationChanged(newConfig);
    }

}
