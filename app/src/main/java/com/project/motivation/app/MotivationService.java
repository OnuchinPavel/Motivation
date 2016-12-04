package com.project.motivation.app;

import com.project.motivation.mvp.models.Post;

import java.util.List;

import retrofit2.Call;
import rx.Observable;

/**
 * Created by onuchin on 03.12.2016.
 */

public class MotivationService {

    private  MotivationApi mMotivationApi;

    public MotivationService(MotivationApi mMotivationApi) {
        this.mMotivationApi = mMotivationApi;
    }

    public Call<List<Post>> getMotivation(){return  mMotivationApi.getMotivation();}
}
