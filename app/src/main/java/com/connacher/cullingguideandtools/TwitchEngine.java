package com.connacher.cullingguideandtools;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Ross on 5/27/2017.
 */

public class TwitchEngine {
    private static final String CLIENT_ID ="wxhref3x44pp98h4y46m7uvwmn0sqd";
    private TwitchService mService;

    public TwitchEngine(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.twitch.tv/kraken/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        mService = retrofit.create(TwitchService.class);
    }

    public Call<String> getAllStreams(String stream_type, String game){
        return mService.getAllStreams(CLIENT_ID,stream_type,game);
    }

}
