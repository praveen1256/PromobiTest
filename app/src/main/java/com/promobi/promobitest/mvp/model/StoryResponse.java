package com.promobi.promobitest.mvp.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@AutoValue
public abstract class StoryResponse {


    public static TypeAdapter<StoryResponse> typeAdapter(Gson gson) {
        return new AutoValue_StoryResponse.GsonTypeAdapter(gson);
    }


    @SerializedName("status")
    public abstract String status();

    @SerializedName("copyright")
    public abstract String copyright();

    @SerializedName("section")
    public abstract String section();

    @SerializedName("last_updated")
    public abstract String lastUpdated();

    @SerializedName("num_results")
    public abstract Integer numResults();

    @SerializedName("results")
    public abstract List<StoryItem> results();
}