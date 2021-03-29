package com.example.helpyouout;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;



import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helpyouout.constants.AppHeart;
import com.example.helpyouout.databinding.ActivityLogInBinding;
import com.example.helpyouout.databinding.ActivitySignInBinding;
import com.example.helpyouout.main.BaseActivity;
import com.example.helpyouout.model.UserData;
import com.example.helpyouout.model.UserModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpStage1 extends BaseActivity {

    ActivitySignInBinding binding;
    Spinner gender;
    TextView tvDate;
    DatePickerDialog.OnDateSetListener setListener;
    Button previous, signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        //BirthDate code
        tvDate = findViewById(R.id.tv_birthday);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(SignUpStage1.this, android.R.style.Theme_Holo_Dialog_MinWidth, setListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();

            }
        });

        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = "   " + day + "/" + month + "/" + year;
                tvDate.setText(date);
            }
        };
        //gender code
        gender = findViewById(R.id.gender);

        String[] value = {"Male", "Female", "other"};
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(value));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.style_gender, arrayList);
        gender.setAdapter(arrayAdapter);

    }

    @NotNull
    @Override
    public View setContentView() {
        binding = ActivitySignInBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void init() {
    }

    @Override
    public void buttonClicks() {

        binding.SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = binding.emailToSignUp.getText().toString().trim();
                String password = binding.passwordToSignUp.getText().toString().trim();
                String name = binding.name.getText().toString().trim();

                if (email.isEmpty()) {
                    Toast.makeText(context, "Please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.isEmpty()) {
                    Toast.makeText(context, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (name.isEmpty()) {
                    Toast.makeText(context, "Please enter name", Toast.LENGTH_SHORT).show();
                    return;
                }

                HashMap<String, String > signinBody = new HashMap<>();
                signinBody.put(AppHeart.PARAM_EMAIL, email);
                signinBody.put(AppHeart.PARAM_PASSWORD, password);
                signinBody.put(AppHeart.PARAM_NAME,name);
                signinBody.put(AppHeart.PARAM_PHONE,"1234567890");
                signinBody.put(AppHeart.PARAM_VERIFIED,"1");

                final ProgressDialog dialog = ProgressDialog.show(context, "Loading", "Signing you in...");

                callWS().userRegister(signinBody).enqueue(new Callback<UserModel>() {
                    @Override
                    public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                        dialog.dismiss();

                        if (response.isSuccessful() && response.body().getStatus()) {
                            startActivity(new Intent(SignUpStage1.this, LoginScreen.class));
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



    }

    @NotNull
    @Override
    public String getLoggerTag() {
        return "SignUpStage1";
    }


    private void checkTestApi() {

        final ProgressDialog dialog = ProgressDialog.show(context, "Loading", "Signing you in...");

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
