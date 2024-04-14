package com.example.relam_gg.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RiotApiService {
    @GET("riot/account/v1/accounts/by-riot-id/{gameName}/{tagLine}")
    @Headers({"X-Riot-Token: INSERT TOKEN"})
    Call<Account> getAccountInfo(
            @Path("gameName") String gameName,
            @Path("tagLine") String tagLine

    );

    // ADD NEW METHODS...
    @POST("riot/account/v1/accounts/by-riot-id/{gameName}/{tagLine}")
    @Headers({"X-Riot-Token: INSERT TOKEN"})
    Call<Account> getAccountIno(
            @Path("gameName") String gameName,
            @Path("tagLine") String tagLine

    );
}
