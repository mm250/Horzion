package com.morcode.horzion.screen;

import android.content.Context;

import com.morcode.horzion.App;
import com.morcode.horzion.R;
import com.morcode.horzion.ui.events.OffCanvasEvent;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

public class OffCanvasScreenManager extends ScreenManagerImpl {

    @Inject
    Bus bus;

    public OffCanvasScreenManager (Context app) {
        super ();
        ((App) app).inject(this);
        bus.register(this);
    }

    @Subscribe
    public void onOffCanvasEvent(OffCanvasEvent event) {
        loadScreen(R.id.content_frame, "home");
    }

}
