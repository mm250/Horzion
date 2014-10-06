package com.morcode.horzion;

import com.morcode.horzion.activity.ActivityModule;
import com.morcode.horzion.screen.OffCanvasScreenManager;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mauricemorgan on 05/10/2014.
 */
@Module(
        injects = {
            OffCanvasScreenManager.class
        },
        library = true
)
public class DomainModule {


    @Provides @Singleton
    public Bus provideBus () {
        return new Bus();
    }
}
