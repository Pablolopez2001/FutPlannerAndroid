package com.futplanner.futplannerandroid.util;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NetworkUtil {
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    public static final String URL = "http://46.4.74.141:8080/api/";

    public static String post(String url, String jsonBody) throws IOException {
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(jsonBody, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}