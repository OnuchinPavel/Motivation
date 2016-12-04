package com.project.motivation.mvp.common;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.arellomobile.mvp.MvpDelegate;
import com.project.mylibrary.BackStackActivity;


/**
 * Created by onuchin on 23.11.2016.
 */

public class MvpAppCompatActivity extends BackStackActivity {

    private MvpDelegate<? extends MvpAppCompatActivity> mMvpDelegate;

    public MvpDelegate getMvpDelegate(){
        if(mMvpDelegate==null){
            mMvpDelegate= new MvpDelegate<>(this);
        }
        return  mMvpDelegate;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMvpDelegate().onCreate(savedInstanceState);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getMvpDelegate().onDetach();
        if(isFinishing()){
            getMvpDelegate().onDestroy();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getMvpDelegate().onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getMvpDelegate().onAttach();
    }
}
