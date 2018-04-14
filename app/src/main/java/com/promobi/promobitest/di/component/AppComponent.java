package com.promobi.promobitest.di.component;


import com.promobi.promobitest.MainActivity;
import com.promobi.promobitest.api.ImageDownloader;
import com.promobi.promobitest.api.NyTimesApi;
import com.promobi.promobitest.api.RetrofitInterceptor;
import com.promobi.promobitest.di.module.AppModule;
import com.promobi.promobitest.di.module.ImageDownloaderModule;
import com.promobi.promobitest.di.module.NetworkModule;
import com.promobi.promobitest.di.module.NyTimesApiModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 *
 *
 */
@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, NyTimesApiModule.class, ImageDownloaderModule.class})
public interface AppComponent {

    void inject(MainActivity activity);


    void inject(RetrofitInterceptor interceptor);
}
