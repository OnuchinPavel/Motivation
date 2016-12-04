package com.project.motivation.Motivation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.motivation.R;
import com.project.motivation.mvp.models.Post;

import java.util.Collections;
import java.util.List;

/**
 * Created by onuchin on 28.11.2016.
 */

public class MotivationAdapter extends RecyclerView.Adapter<MotivationAdapter.MyViewHolder> {

    private List<Post> motivationList;

    public MotivationAdapter() {
        motivationList = Collections.emptyList();
    }

    public MotivationAdapter(List<Post> motivationList) {
        this.motivationList = motivationList;
    }

    public void setPosts(List<Post> posts){
        this.motivationList=posts;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Post post = motivationList.get(position);
        holder.info.setText(post.getType());
        holder.name.setText(post.getTitle());
    }

    @Override
    public int getItemCount() {
        return motivationList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public TextView info, name, genre;

        public MyViewHolder(View view) {
            super(view);
            info = (TextView) view.findViewById(R.id.textViewInfo);
            name = (TextView) view.findViewById(R.id.textViewName);

        }
    }
}
