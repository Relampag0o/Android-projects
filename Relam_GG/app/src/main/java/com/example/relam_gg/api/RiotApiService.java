package com.example.relam_gg.api;

import com.example.relam_gg.Account;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface RiotApiService {
    @GET("riot/account/v1/accounts/by-riot-id/{gameName}/{tagLine}")
    @Headers("INSERT TOKEN HERE")
    Call<List<Account>> getAccountInfo(
            @Path("gameName") String gameName,
            @Path("tagLine") String tagLine,
            @Url String baseUrl
    );
}
