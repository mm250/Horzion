package com.morcode.horzion.ui;

import android.app.Activity;

/**
 * Created by mauricemorgan on 30/09/2014.
 */
public abstract class UiBase implements UiInterface {

    protected Activity activity;

    public UiBase (Activity p_activity) {
        activity = p_activity;
        onPostCreate();
    }

}
