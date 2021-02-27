package com.example.helpyouout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.ApplicationClass;
import com.example.helpyouout.constants.AppHeart;
import com.example.helpyouout.databinding.ActivityLogInBinding;
import com.example.helpyouout.main.BaseActivity;
import com.example.helpyouout.model.UserModel;
import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginScreen extends BaseActivity {

    ActivityLogInBinding binding;

    @NotNull
    @Override
    public View setContentView() {
        binding = ActivityLogInBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void init() {
    }

    @Override
    public void buttonClicks() {

        binding.logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = binding.email.getText().toString().trim();
                String password = binding.password.getText().toString().trim();

                if (email.isEmpty()) {
                    Toast.makeText(context, "Please enter valid email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.isEmpty()) {
                    Toast.makeText(context, "Please enter valid password", Toast.LENGTH_SHORT).show();
                    return;
                }

                HashMap<String, String> loginBody = new HashMap<>();
                loginBody.put(AppHeart.PARAM_EMAIL, email);
                loginBody.put(AppHeart.PARAM_PASSWORD, password);

                final ProgressDialog dialog = ProgressDialog.show(context, "Loading", "Logging you in...");

                callWS().userLogin(loginBody).enqueue(new Callback<UserModel>() {
                    @Override
                    public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                        dialog.dismiss();

                        if (response.isSuccessful() && response.body().getStatus()) {

                            /*
                             * Save user details
                             * */
                            ApplicationClass.app.saveUserDetails(response.body());

                            startActivity(new Intent(LoginScreen.this, HomeActivity.class));
                            finish();
                        } else {
                            Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<UserModel> call, Throwable t) {
                        dialog.dismiss();

                        Toast.makeText(context, "Something went wrong.", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        });

        binding.signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginScreen.this, SignUpStage1.class));
            }
        });


    }

    @NotNull
    @Override
    public String getLoggerTag() {
        return "LoginScreen";
    }


    private void checkTestApi() {

        final ProgressDialog dialog = ProgressDialog.show(context, "Loading", "Logging you in...");

        callWS().test().enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                dialog.dismiss();
                Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                dialog.dismiss();

                Toast.makeText(context, "Something went wrong.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}