package com.promobi.promobitest.di.module;

import android.content.Context;

import com.promobi.promobitest.api.ImageDownloader;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Praveen on 10-04-2018.
 */

@Module
public class ImageDownloaderModule {
    private Context context;

    public ImageDownloaderModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    ImageDownloader provideImageDownloader(Context context) {
        return new ImageDownloader(context);
    }
}
