package com.project.motivation.Motivation;

import android.content.Context;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.project.motivation.MotivationApp;
import com.project.motivation.app.MotivationService;
import com.project.motivation.mvp.common.RxUtils;
import com.project.motivation.mvp.models.Post;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.schedulers.Schedulers;

/**
 * Created by onuchin on 28.11.2016.
 */
@InjectViewState
public class MotivationPresenter extends MvpPresenter<MotivationView> {
    @Inject
    MotivationService mMotivationService;
    private  boolean mIsInLoading;
    private Subscription subscription;
    private List<Post> posts;
    Context context ;
    public MotivationPresenter() {
        MotivationApp.getAppComponent().inject(this);

    }



    public  void loadMotivationPost(){loadPost();}
    public  void loadPost(){
        getViewState().hideError();
        getViewState().onStartLoading();

        final Observable<List<Post>> observable = RxUtils.wrapRetrofitCall(mMotivationService.getMotivation());
        RxUtils.wrapAsync(observable, Schedulers.io())
                .subscribe(posts -> {
                    onLoadingFinish();
                    onLoadingSuccess(posts);
                },
                        throwable -> {
                            onLoadingFinish();
                            onLoadingFailed(throwable);
                        });
    }

    private void onLoadingFinish(){
        getViewState().onFinishLoading();
        hideProgress();
    }
    private void onLoadingSuccess(List<Post> motivationPost){
        getViewState().setPosts(motivationPost);
    }
    private  void  onLoadingFailed(Throwable throwable){
        getViewState().showError(throwable.toString());
    }
    private  void closeError(){getViewState().hideError();}
    private  void hideProgress(){getViewState().hideError();}
}
