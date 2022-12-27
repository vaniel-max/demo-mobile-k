
package com.example.demomobilv4.service;

import com.example.demomobilv4.dto.RespuestaLogin;
import com.example.demomobilv4.dto.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface NewtonService {

    @POST("auth/signin")
    Call<RespuestaLogin> login(@Body User user);




}