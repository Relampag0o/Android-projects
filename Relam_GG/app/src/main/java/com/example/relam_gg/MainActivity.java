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

        Call<List<Account>> call = riotApiClient.getRiotApiService().getAccountInfo(gameName, tagLine, baseUrl);

        Log.d("API Request", call.request().url().toString());

        call.enqueue(new Callback<List<Account>>() {
            @Override
            public void onResponse(Call<List<Account>> call, Response<List<Account>> response) {
                if (response.isSuccessful()) {
                    List<Account> accounts = response.body();
                    System.out.println(accounts.size());
                    for (Account account : accounts) {
                            Log.d("API Response", account.toString());
                    }
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
            public void onFailure(Call<List<Account>> call, Throwable t) {
                Log.e("API Error", "Fallo en la llamada", t);
            }
        });
    }
    }
