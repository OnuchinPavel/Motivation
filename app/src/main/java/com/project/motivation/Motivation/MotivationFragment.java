package com.project.motivation.Motivation;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.project.motivation.R;
import com.project.motivation.mvp.common.MvpAppCompatFragment;
import com.project.motivation.mvp.models.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by onuchin on 23.11.2016.
 */

public class MotivationFragment extends MvpAppCompatFragment implements MotivationView {
    @InjectPresenter
    MotivationPresenter mMotivationPresenter;
    private RecyclerView postRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.list_motivation_fragment, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMotivationPresenter = new MotivationPresenter();
        postRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        MotivationAdapter adapter = new MotivationAdapter();
        mMotivationPresenter.loadMotivationPost();


        postRecyclerView.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        postRecyclerView.setAdapter(adapter);
        postRecyclerView.setLayoutManager(layoutManager);


    /*    recyclerView.setHasFixedSize(true);
        MotivationAdapter  adapter =new MotivationAdapter();
        mMotivationPresenter.loadMotivationPost();
*/

     /*   //adapter = new MotivationAdapter(postList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);*/


    }




    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void hideError() {

    }

    @Override
    public void onStartLoading() {

    }

    @Override
    public void onFinishLoading() {

    }

    @Override
    public void showRefreshing() {

    }

    @Override
    public void hideRefreshing() {

    }

    @Override
    public void showListProgress() {

    }

    @Override
    public void hideListProgress() {

    }

    @Override
    public void setPosts(List<Post> posts) {

    }
}
