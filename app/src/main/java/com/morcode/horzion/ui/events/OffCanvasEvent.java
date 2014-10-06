package com.morcode.horzion.ui.events;

import javax.inject.Inject;

public class OffCanvasEvent {

    private int sideMenuItemId;

    @Inject
    public OffCanvasEvent () {}

    public OffCanvasEvent (int sideMenuItemId) {
        this.sideMenuItemId = sideMenuItemId;
    }

    public int getSideMenuItemId () {
        return sideMenuItemId;
    }

    public void setSideMenuItemId (int sideMenuItemId) {
        this.sideMenuItemId = sideMenuItemId;
    }

}
