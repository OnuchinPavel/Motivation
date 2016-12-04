package com.project.motivation.di;

import com.project.motivation.app.MotivationApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by onuchin on 03.12.2016.
 */
@Module(includes = {RetrofitModule.class})
public class ApiModule {
    @Provides
    @Singleton
    public MotivationApi  provideAuthApi(Retrofit retrofit){return  retrofit.create(MotivationApi.class);}
}
