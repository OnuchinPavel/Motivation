package com.project.motivation.Favorite;

import com.arellomobile.mvp.MvpView;
import com.project.motivation.mvp.models.FavoritePost;

import java.util.List;

/**
 * Created by onuchin on 28.11.2016.
 */

public interface FavoriteView extends MvpView {
    void loadFavorite(List<FavoritePost> favotitePosts) ;
    void showProgress();
    void hideProgress();
    void showError();
}
