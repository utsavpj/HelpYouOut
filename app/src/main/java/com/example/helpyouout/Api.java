package com.example.helpyouout;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("register")
    Call<ResponseBody> register(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("mobile") Integer mobile,
            @Field("verified") Integer verified

   );
    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> logIn(
            @Field("email") String email,
            @Field("password") String password
    );


}
