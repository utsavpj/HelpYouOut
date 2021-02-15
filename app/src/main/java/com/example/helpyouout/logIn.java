package com.example.helpyouout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class logIn extends AppCompatActivity {

    EditText email;
    EditText spassword;
    Button login;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        email = findViewById(R.id.email);
        spassword = findViewById(R.id.password);
        login = findViewById(R.id.logIn);


        Button signUpButton = findViewById(R.id.signUp);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(logIn.this,signIn.class));
            }
        });

        Button logInButton = findViewById(R.id.logIn);
        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(logIn.this, HomeActivity.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = logIn.this.email.getText().toString();
                String password = spassword.getText().toString();
                //validate form
                if(validateLogin(email, password)){
                    //do login
                    doLogin(email, password);
                }
            }
        });

    }

    private boolean validateLogin(String username, String password){
        if(username == null || username.trim().length() == 0){
            Toast.makeText(this, "Username is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(password == null || password.trim().length() == 0){
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void doLogin(final String email,final String password){
//        Call<Post> call = RetrofitClient.ge
////        Call call = userService.login(email,password);
//        call.enqueue(new Callback() {
//            @Override
//            public void onResponse(Call call, Response response) {
//                if(response.isSuccessful()){
////                    ResObj resObj= (ResObj) response.body();
////                    if(resObj.getEmail().equals("true") && resObj.getPassword().equals("true")){
////                        //login start main activity
////                        Intent intent = new Intent(logIn.this, MainActivity.class);
////                        intent.putExtra("email", email);
////                        startActivity(intent);
//
//                    } else {
//                        Toast.makeText(logIn.this, "The email or password is incorrect", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(logIn.this, "Error! Please try again!", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                Toast.makeText(logIn.this,
//                        t.getMessage(),
//                        Toast.LENGTH_SHORT).show();
            }

}




