package com.project.motivation.mvp.common;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;


import com.arellomobile.mvp.MvpDelegate;

/**
 * Created by onuchin on 23.11.2016.
 */

public class MvpAppCompatFragment extends Fragment {
    MvpDelegate<? extends MvpAppCompatFragment > mMvpDelegate;

    public MvpDelegate getMvpDelegate(){
        if(mMvpDelegate==null){
            mMvpDelegate=new MvpDelegate<>(this);
        }
        return  mMvpDelegate;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMvpDelegate().onCreate(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(isRemoving()){
            getMvpDelegate().onDestroy();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        getMvpDelegate().onAttach();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getMvpDelegate().onSaveInstanceState(outState);
    }
}
