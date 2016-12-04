package com.project.motivation.di;

import android.content.Context;

import com.project.motivation.Motivation.MotivationPresenter;
import com.project.motivation.app.MotivationService;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.*;

/**
 * Created by onuchin on 03.12.2016.
 */

@Singleton
@dagger.Component(modules = {ContextModule.class,BusModule.class,MotivationModule.class})
public interface AppComponent {
    Context getContext();
    MotivationService getMotivationService();
    Bus getBus();

    void inject(MotivationPresenter presenter);
}
