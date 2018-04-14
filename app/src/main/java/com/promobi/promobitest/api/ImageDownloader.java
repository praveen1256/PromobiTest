package com.promobi.promobitest.api;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Praveen on 10-04-2018.
 */

public class ImageDownloader {

    private Context context;

    public ImageDownloader(Context context) {
        this.context = context;
    }

    public void toImageView(ImageView imageView, String url){
        Glide.with(context).load(url).into(imageView);

    }

}
