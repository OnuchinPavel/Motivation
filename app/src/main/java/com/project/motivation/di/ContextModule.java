package com.project.motivation.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by onuchin on 03.12.2016.
 */

@Module
public class ContextModule {
private Context mContext;

    public ContextModule(Context context){
        mContext=context;

    }
    @Provides
    @Singleton

    public Context provideContext(){return  mContext;}

}
