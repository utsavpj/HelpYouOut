package com.example.helpyouout.webservice;


import com.example.helpyouout.model.AllQuestionModel;
import com.example.helpyouout.model.QuestionModel;
import com.example.helpyouout.model.UserData;
import com.example.helpyouout.model.UserModel;
import com.google.gson.JsonElement;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Harsh on 29/12/17.
 */
public interface ServiceInterface {

    @GET("/")
    Call<UserModel> test();

    @POST("login")
    Call<UserModel> userLogin(@Body HashMap<String, String> requestBody);

    @POST("register")
    Call<UserModel> userRegister(@Body HashMap<String,String> requestBody);

    @GET("getAllQuestion")
    Call<AllQuestionModel> allQuestion();

    @GET("getTestQuestion")
    Call<AllQuestionModel> testQuestion();

    @GET("getQuestion")
    Call<QuestionModel> question();

}