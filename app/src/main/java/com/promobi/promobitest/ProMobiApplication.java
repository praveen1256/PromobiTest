package com.promobi.promobitest;

import android.app.Application;

import com.promobi.promobitest.di.component.AppComponent;
import com.promobi.promobitest.di.component.DaggerAppComponent;
import com.promobi.promobitest.di.module.AppModule;
import com.promobi.promobitest.di.module.ImageDownloaderModule;
import com.promobi.promobitest.di.module.NetworkModule;
import com.promobi.promobitest.di.module.NyTimesApiModule;

/**
 * Main application class. Initializes dagger.
 */
public class ProMobiApplication extends Application {

    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .nyTimesApiModule(new NyTimesApiModule())
                .imageDownloaderModule(new ImageDownloaderModule(this))
                .build();
    }

    public static AppComponent getComponent() {
        return component;
    }
}
