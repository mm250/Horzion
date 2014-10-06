package com.morcode.horzion.screen;

import android.app.Fragment;
import android.app.FragmentManager;

import java.util.HashMap;


public interface ScreenManager {

    public Fragment getFragment (String fragmentName);

    public void addFragment (String fragmentName, Fragment fragment);

    public void setFragmentManager (FragmentManager fragmentManager);

    public FragmentManager getFragmentManager ();

    public void loadScreen (int id, String fragmentName);

}
