package com.project.motivation.di;

import android.content.Context;

import com.project.motivation.Motivation.MotivationPresenter;
import com.project.motivation.app.MotivationApi;
import com.project.motivation.app.MotivationService;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

/**
 * Created by onuchin on 03.12.2016.
 */

@Singleton
@dagger.Component(modules = {ContextModule.class,MotivationModule.class,BusModule.class})
public interface Component {
Context getContext();
    MotivationService getMotivationService();
    Bus getBus();

    void inject(MotivationPresenter presenter);

}
