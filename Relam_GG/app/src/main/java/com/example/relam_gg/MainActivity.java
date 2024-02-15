package com.example.relam_gg;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.relam_gg.api.RiotApiClient;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RiotApiClient riotApiClient = new RiotApiClient();
        String baseUrl = "https://europe.api.riotgames.com/";
        String gameName = "Pepe";
        String tagLine = "euw";

        Call<Account> call = riotApiClient.getRiotApiService().getAccountInfo(gameName, tagLine);

        Log.d("API Request", call.request().url().toString());

        call.enqueue(new Callback<Account>() {
            @Override
            public void onResponse(Call<Account> call, Response<Account> response) {
                if (response.isSuccessful()) {
                    Account accounts = response.body();
                    System.out.println(accounts);

                } else {

                    try {
                        String errorBody = response.errorBody().string();
                        Log.e("API Error", errorBody);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<Account> call, Throwable t) {
                Log.e("API Error", "Fallo en la llamada", t);
            }
        });
    }
    }
