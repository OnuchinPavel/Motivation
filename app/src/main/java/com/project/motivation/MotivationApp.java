package com.project.motivation;

import android.app.Application;

import com.project.motivation.di.AppComponent;
import com.project.motivation.di.ContextModule;
import com.project.motivation.di.DaggerAppComponent;
import com.squareup.otto.Bus;

/**
 * Created by onuchin on 03.12.2016.
 */

public class MotivationApp extends Application {

    private  static Bus bus;
 private  static AppComponent sAppComponent;
    public static  Bus getBus(){return  bus;}
    public void setupBus(){bus = new Bus();}

    @Override
    public void onCreate() {
        super.onCreate();
        setupBus();
        sAppComponent = DaggerAppComponent.builder().contextModule(new ContextModule(this)).build();
    }
    public  static AppComponent getAppComponent(){return  sAppComponent;}
}
