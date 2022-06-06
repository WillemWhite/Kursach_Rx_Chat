package com.example.kursach;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ChatMessageApi {
    @GET("/messages")
    Observable<List<String>> messages();

    @GET("/rooms")
    Observable<List<String>> rooms();
}
