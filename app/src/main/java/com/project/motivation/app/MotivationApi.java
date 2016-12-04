package com.project.motivation.app;

import com.project.motivation.mvp.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by onuchin on 03.12.2016.
 */

public interface MotivationApi {
    @GET("/motivations")
   Call<List<Post>> getMotivation();
}
