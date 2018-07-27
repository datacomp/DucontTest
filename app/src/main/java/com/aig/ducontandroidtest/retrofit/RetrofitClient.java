package com.aig.ducontandroidtest.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import okhttp3.OkHttpClient;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static com.aig.ducontandroidtest.util.Constants.BASE_URL;

public class RetrofitClient {
//    public static final String BASE_URL = "";
    private static Retrofit client;



    public static Retrofit getRetrofitClient(){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        //        new GetData().execute();
        OkHttpClient builder = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();


        if(client == null){
            client = new Retrofit.Builder()
                    .client(builder)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
        }
        return client;
    }
}
