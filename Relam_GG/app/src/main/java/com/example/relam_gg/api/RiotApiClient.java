package com.example.relam_gg.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RiotApiClient {
    private static final String BASE_URL = "https://api.riotgames.com/";

    private final RiotApiService riotApiService;

    public RiotApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        riotApiService = retrofit.create(RiotApiService.class);
    }

    public RiotApiService getRiotApiService() {
        return riotApiService;
    }
}
