package com.promobi.promobitest.mvp.model;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Praveen on 12-04-2018.
 */
@AutoValue
public abstract class Multimedia {

    @SerializedName("url")
    public abstract String url();

    @SerializedName("format")
    public abstract String format();

    @SerializedName("height")
    public abstract Integer height();

    @SerializedName("width")
    public abstract Integer width();

    @SerializedName("type")
    public abstract String type();

    @SerializedName("subtype")
    public abstract String subtype();

    @SerializedName("caption")
    public abstract String caption();

    @SerializedName("copyright")
    public abstract String copyright();

    public static TypeAdapter<Multimedia> typeAdapter(Gson gson) {
        return new AutoValue_Multimedia.GsonTypeAdapter(gson);
    }

}
