package com.promobi.promobitest.mvp.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@AutoValue
public abstract class StoryItem {


    public static TypeAdapter<StoryItem> typeAdapter(Gson gson) {
        return new AutoValue_StoryItem.GsonTypeAdapter(gson);
    }


    @SerializedName("section")
    public abstract String section();

    @SerializedName("subsection")
    public abstract String subsection();

    @SerializedName("title")
    public abstract String title();

    @SerializedName("abstract")
    public abstract String _abstract();

    @SerializedName("url")
    public abstract String url();

    @SerializedName("byline")
    public abstract String byline();

    @SerializedName("item_type")
    public abstract String itemType();

    @SerializedName("updated_date")
    public abstract String updatedDate();

    @SerializedName("created_date")
    public abstract String createdDate();

    @SerializedName("published_date")
    public abstract String publishedDate();

    @SerializedName("material_type_facet")
    public abstract String materialTypeFacet();

    @SerializedName("kicker")
    public abstract String kicker();

    @SerializedName("des_facet")
    public abstract List<String> desFacet();

    @SerializedName("org_facet")
    public abstract List<String> orgFacet();

    @SerializedName("per_facet")
    public abstract List<String> perFacet();

    @SerializedName("geo_facet")
    public abstract List<String> geoFacet();

    @SerializedName("multimedia")
    public abstract List<Multimedia> multimedia();

    @SerializedName("short_url")
    public abstract String shortUrl();


}