package com.promobi.promobitest.api;

import com.promobi.promobitest.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Interceptor for Retrofit to add auth key to header
 */
public class RetrofitInterceptor implements Interceptor {

//    private String token = null;

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();

//        if (token == null) {
//            ResponseBody body = chain.proceed(getToken()).body();
//
//            try {
//                JSONObject jsonObject = new JSONObject(body.string());
//                token = "Bearer " + jsonObject.optString("access_token");
//            } catch (JSONException e) {
//                e.printStackTrace();
//                Log.d(RetrofitInterceptor.class.getName(), "Error fetching token");
//            }
//        }

        request = request.newBuilder()
                .addHeader("apikey", BuildConfig.API_KEY)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();

        return chain.proceed(request);
    }

//    private Request getToken() {
//        String bearerToken = BuildConfig.CONSUMER_KEY +
//                ":" + BuildConfig.CONSUMER_SECRET;
//
//        String base64BearerToken = "Basic " + Base64.encodeToString(bearerToken.getBytes(), Base64.NO_WRAP);
//        RequestBody requestBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8"), "grant_type=client_credentials");
//
//        return new Request.Builder()
//                .url(BuildConfig.AUTH_END_POINT)
//                .post(requestBody)
//                .header("Authorization", base64BearerToken)
//                .header("Content-Encoding", "gzip")
//                .header("User-Agent", "My Twitter App v1.0.23")
//                .header("Content-type", "application/x-www-form-urlencoded;charset=UTF-8")
//                .build();
//    }
}