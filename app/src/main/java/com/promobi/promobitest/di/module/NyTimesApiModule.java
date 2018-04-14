package com.promobi.promobitest.di.module;

import com.promobi.promobitest.api.NyTimesApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 *
 *
 */
@Module
public class NyTimesApiModule {

    @Provides
    @Singleton
    NyTimesApi provideRetrofit(Retrofit retrofit) {
        return retrofit.create(NyTimesApi.class);
    }

}
