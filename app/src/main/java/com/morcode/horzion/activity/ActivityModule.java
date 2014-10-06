package com.morcode.horzion.activity;

import com.morcode.horzion.ui.OffCanvas;

import dagger.Module;

@Module(
    injects = {
        Home.class,
        OffCanvas.class
    },
    complete = false,
    library = true
)
public class ActivityModule {

}