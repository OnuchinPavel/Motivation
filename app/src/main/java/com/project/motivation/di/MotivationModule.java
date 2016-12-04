package com.project.motivation.di;

import com.project.motivation.app.MotivationApi;
import com.project.motivation.app.MotivationService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by onuchin on 03.12.2016.
 */

@Module(includes = {ApiModule.class})
public class MotivationModule {
    @Provides
    @Singleton
    public MotivationService provideMotivationService(MotivationApi motivationApi){

        return new MotivationService(motivationApi);
    }
}
