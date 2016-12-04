package com.project.motivation.mvp.common;

import com.project.motivation.app.MotivationError;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import rx.Observable;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by onuchin on 03.12.2016.
 */

public class RxUtils {

    public static  <T>Observable<T> wrapRetrofitCall(final Call<T> call){
        return  Observable.create(subscriber -> {
            final Response<T> execute;
            try {
                execute= call.execute();
            }
            catch (IOException e ){
                subscriber.onError(e);
                return;
            }
            if (execute.isSuccess()){
                subscriber.onNext(execute.body());
            }
            else {
                subscriber.onError(new MotivationError(execute.errorBody()));
            }
        });
    }

    public static  <T>Observable<T> wrapAsync(Observable<T>  observable, Scheduler scheduler){
        return observable.subscribeOn(scheduler).observeOn(AndroidSchedulers.mainThread());
    }
}
