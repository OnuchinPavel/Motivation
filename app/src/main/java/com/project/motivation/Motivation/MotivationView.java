package com.project.motivation.Motivation;

import android.content.Context;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.project.motivation.mvp.models.Post;

import java.util.List;

/**
 * Created by onuchin on 28.11.2016.
 */
@StateStrategyType(AddToEndSingleStrategy.class)
public interface MotivationView extends MvpView {


    void showError(String message);
    void hideError();
    void onStartLoading();
    void onFinishLoading();
    void showRefreshing();
    void hideRefreshing();
    void showListProgress();
    void hideListProgress();
    //загрузка списка статей
    void setPosts(List<Post> posts);

}
