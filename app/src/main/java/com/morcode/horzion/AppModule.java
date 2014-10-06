package com.morcode.horzion;

import android.content.Context;

import com.morcode.horzion.activity.ActivityModule;

import com.morcode.horzion.screen.OffCanvasScreenManager;
import com.morcode.horzion.screen.ScreenManager;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
    injects = {
        App.class
    },
    includes = {
        ActivityModule.class,
        DomainModule.class
    },
    library = true
)

public class AppModule {

    private Context app;

    public AppModule (App app) {
        this.app = app;
    }

    @Provides @Singleton
    public Context provideApp () {
        return app;
    }

    @Provides @Singleton
    public ScreenManager provideScreenManager () {
        return new OffCanvasScreenManager(app);
    }

}
