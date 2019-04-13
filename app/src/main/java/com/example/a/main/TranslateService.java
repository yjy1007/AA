package com.example.a.main;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface TranslateService {
    @GET("translate?")
    Call<WordBean> translate(@Query("doctype") String doctype, @Query("type") String type, @Query("i") String i);
}