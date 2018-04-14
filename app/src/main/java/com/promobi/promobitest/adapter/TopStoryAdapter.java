package com.promobi.promobitest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.promobi.promobitest.R;
import com.promobi.promobitest.api.ImageDownloader;
import com.promobi.promobitest.mvp.model.StoryItem;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Praveen on 25-02-2018.
 */

public class TopStoryAdapter extends RecyclerView.Adapter<TopStoryAdapter.MyViewHolder> {


    private final ImageDownloader imageDownloader;
    private List<StoryItem> storyItemList;
    private int positionm;

    public TopStoryAdapter(List<StoryItem> storyItemList, int position,ImageDownloader imageDownloader) {
        this.storyItemList = storyItemList;
        this.positionm = position;
        this.imageDownloader = imageDownloader;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_section, tv_item_type;
        ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            tv_section = (TextView) view.findViewById(R.id.tv_section);
            tv_item_type = (TextView) view.findViewById(R.id.tv_item_type);
            imageView =view.findViewById(R.id.imageView);
        }
    }


    public TopStoryAdapter(List<StoryItem> storyItemList,ImageDownloader imageDownloader) {
        this.storyItemList = storyItemList;
        this.imageDownloader = imageDownloader;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_story, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        StoryItem storyItem = storyItemList.get(position);
        holder.tv_section.setText(storyItem.section()+", "+ storyItem.itemType());
        holder.tv_item_type.setText(storyItem.title());
        if(storyItem.multimedia().size()>0) {
            imageDownloader.toImageView(holder.imageView, storyItem.multimedia().get(0).url());
        }
    }

    @Override
    public int getItemCount() {
        return storyItemList.size();
    }
}