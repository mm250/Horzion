package com.morcode.horzion;

import android.app.Application;
import android.content.Context;

import com.squareup.otto.Bus;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import dagger.ObjectGraph;

/**
 * Created by mauricemorgan on 04/10/2014.
 */
public class App extends Application {

    private ObjectGraph objectGraph;

    @Inject
    Bus bus;

    @Override
    public void onCreate() {
        super.onCreate();
        objectGraph = ObjectGraph.create(getModules().toArray());
        objectGraph.inject(this);
    }

    private List<Object> getModules() {
        return Arrays.<Object>asList(new AppModule(this));
    }

    public ObjectGraph createScopedGraph(Object... modules) {
        return objectGraph.plus(modules);
    }

    public void inject(Object t){
        objectGraph.inject(t);
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

}