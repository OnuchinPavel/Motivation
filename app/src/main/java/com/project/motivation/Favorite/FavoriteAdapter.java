package com.project.motivation.Favorite;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.motivation.R;
import com.project.motivation.mvp.models.FavoritePost;

import java.util.List;

import butterknife.BindView;

/**
 * Created by onuchin on 29.11.2016.
 */

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ViewHolder> {

     private List<FavoritePost>  favoriteList;
    @Override
    public FavoriteAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_list_item,parent,false);
        return  new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FavoriteAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return favoriteList.size();
    }
    public class  ViewHolder extends RecyclerView.ViewHolder{

   /*    @BindView(R.id.)*/

        public ViewHolder(View view) {
            super(view);
         /*   info = (TextView) view.findViewById(R.id.textViewInfo);
            name = (TextView) view.findViewById(R.id.textViewName);*/

        }
    }
}
