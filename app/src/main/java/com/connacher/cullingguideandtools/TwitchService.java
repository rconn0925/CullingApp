package com.connacher.cullingguideandtools;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Ross on 5/27/2017.
 */

public interface TwitchService {
    @GET("/kraken/streams")
    Call<String> getAllStreams(@Header("Client-ID")String clientID,@Query("stream_type") String stream_type, @Query("game") String game);
}
