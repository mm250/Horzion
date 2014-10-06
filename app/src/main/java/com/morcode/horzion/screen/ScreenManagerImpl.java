package com.morcode.horzion.screen;

import android.app.Fragment;
import android.app.FragmentManager;

import java.util.HashMap;

public class ScreenManagerImpl implements ScreenManager {

    private FragmentManager fragmentManager;
    private HashMap <String, Fragment> fragmentsMap;

    public ScreenManagerImpl() {
        fragmentsMap = new HashMap <String, Fragment>();
    }

    public Fragment getFragment (String fragmentName) {
       return fragmentsMap.get(fragmentName);
    }

    public void addFragment (String fragmentName, Fragment fragment) {
        fragmentsMap.put(fragmentName, fragment);
    }

    public void setFragmentManager (FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public FragmentManager getFragmentManager () {
        return fragmentManager;
    }

    public void loadScreen (int id, String fragmentName) {
        fragmentManager.beginTransaction().replace(id, getFragment(fragmentName)).commit();
    }

}
