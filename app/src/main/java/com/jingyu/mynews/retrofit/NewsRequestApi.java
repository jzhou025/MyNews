package com.jingyu.mynews.retrofit;

import com.jingyu.mynews.retrofit.response.BaseResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

// Retrofit turns HTTP API into a Java Interface
public interface NewsRequestApi {

    // request
    @GET("top-headlines")
    Observable<BaseResponse> getNewsByCountry(@Query("country") String country);
}

