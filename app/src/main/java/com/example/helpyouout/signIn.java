package com.example.helpyouout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class signIn extends AppCompatActivity {
    EditText emailToSignUp;
    EditText passwordToSignUp;
    EditText userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        emailToSignUp = findViewById(R.id.emailToSignUp);
        passwordToSignUp = findViewById(R.id.passwordToSignUp);
        userName = findViewById(R.id.name);


//        Button nextButton = findViewById(R.id.next);
//        nextButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//              startActivity(new Intent(signIn.this,signin2.class));
//            }
//        });


        Call<ResponseBody> registerCall = RetrofitClient
                .getInstance()
                .getApi()
                .register(userName,emailToSignUp,passwordToSignUp,mobile,verified);

        registerCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });

    }
}