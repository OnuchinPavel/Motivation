package com.project.motivation.mvp;

import android.widget.BaseAdapter;

import com.arellomobile.mvp.MvpDelegate;

/**
 * Created by onuchin on 28.11.2016.
 */

public  abstract  class MvpBaseAdapter extends BaseAdapter {
    private MvpDelegate<? extends MvpBaseAdapter> mMvpDelegate;
    private MvpDelegate<?> mParentDelegate;
    private String mChildId;

    public MvpBaseAdapter(MvpDelegate<?> mParentDelegate, String mChildId) {
        this.mParentDelegate = mParentDelegate;
        this.mChildId = mChildId;
     getMvpDelegate().onCreate();
    }
    public MvpDelegate getMvpDelegate() {
        if (mMvpDelegate == null) {
            mMvpDelegate = new MvpDelegate<>(this);
            mMvpDelegate.setParentDelegate(mParentDelegate, mChildId);

        }
        return mMvpDelegate;
    }
}
