package com.example.helpyouout.webservice;


import com.example.helpyouout.model.AllQuestionModel;
import com.example.helpyouout.model.GetResultModel;
import com.example.helpyouout.model.QuestionModel;
import com.example.helpyouout.model.SaveResult;
import com.example.helpyouout.model.UserModel;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

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

    @GET("getResult")
    Call<GetResultModel> getResults(@Query(value = "userId", encoded = true) String userId);

    @POST("saveResult")
    Call<SaveResult> saveResult(@Body HashMap<String,String> requestBody);

}