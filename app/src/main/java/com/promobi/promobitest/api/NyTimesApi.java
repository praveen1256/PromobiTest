package com.promobi.promobitest.api;


import com.promobi.promobitest.mvp.model.StoryResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 *
 *
 */

public interface NyTimesApi {
    @GET("topstories/v2/home.json")
    Observable<StoryResponse> getStories();
}
