package com.project.motivation.Favorite;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.project.motivation.R;
import com.project.motivation.mvp.common.MvpAppCompatFragment;
import com.project.motivation.mvp.models.FavoritePost;

import java.util.List;

/**
 * Created by onuchin on 23.11.2016.
 */

public class FavotiteFragment extends MvpAppCompatFragment  implements FavoriteView{
    @InjectPresenter
    FavoritePresenter favoritePresenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.favorite_fragment,container,false);
        return  v;
    }

    @Override
    public void loadFavorite(List<FavoritePost> favotitePosts) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError() {

    }
}
