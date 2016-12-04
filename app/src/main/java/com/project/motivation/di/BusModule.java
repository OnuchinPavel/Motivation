package com.project.motivation.di;

import com.project.motivation.app.MotivationApi;
import com.squareup.otto.Bus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by onuchin on 03.12.2016.
 */

@Module
public class BusModule {
@Provides
    @Singleton
    public Bus provideBus(MotivationApi motivationApi){return  new Bus();}
}
