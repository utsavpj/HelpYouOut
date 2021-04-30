package com.example.helpyouout;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ApplicationClass;
import com.example.helpyouout.databinding.ActivityEditProfileBinding;
import com.example.helpyouout.main.BaseActivity;
import com.example.helpyouout.model.UserModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class EditProfile extends BaseActivity {

    ActivityEditProfileBinding binding;
    Spinner gender;
    final Calendar myCalendar = Calendar.getInstance();

    @NotNull
    @Override
    public View setContentView() {
        binding = ActivityEditProfileBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void init() {
        UserModel userModel = ApplicationClass.app.getUserDetails();
        if (userModel != null) {

            binding.editProfileNameEtv.setText(userModel.getData().getName());
            binding.editProfileEmailEtv.setText(userModel.getData().getEmail());

//            binding.editProfileGenderEtv.setText(userModel.getData().getGender());
            binding.editProfileBirthdayEtv.setText(userModel.getData().getDob());

            //gender code
            gender = findViewById(R.id.gender);

            String[] value = {"Male", "Female", "other"};
            ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(value));
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.style_gender, arrayList);
            gender.setAdapter(arrayAdapter);

            for (int i = 0; i < value.length; i++) {
                if (value[i].toLowerCase().equals(userModel.getData().getGender().toLowerCase())) {
                    gender.setSelection(i);
                    break;
                }
            }
        }


    }

    @Override
    public void buttonClicks() {

        binding.editProfileSaveBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModel userModel = ApplicationClass.app.getUserDetails();
                if (userModel != null) {
                    userModel.getData().setName(binding.editProfileNameEtv.getText().toString());
                    userModel.getData().setEmail(binding.editProfileEmailEtv.getText().toString());
                    userModel.getData().setGender(gender.getSelectedItem().toString());
                    userModel.getData().setDob(binding.editProfileBirthdayEtv.getText().toString());

                    ApplicationClass.app.saveUserDetails(userModel);

                }


                goWithFinish(ProfileScreen.class);
            }
        });

        binding.backep2bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goWithFinish(ProfileScreen.class);
            }
        });

        binding.editProfileBirthdayEtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        // TODO Auto-generated method stub
                        myCalendar.set(Calendar.YEAR, year);
                        myCalendar.set(Calendar.MONTH, monthOfYear);
                        myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        binding.editProfileBirthdayEtv.setText("" + myCalendar.get(Calendar.DAY_OF_MONTH) + "/" + (myCalendar.get(Calendar.MONTH) + 1) + "/" + myCalendar.get(Calendar.YEAR));

                    }
                };


                new DatePickerDialog(context, date, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DATE)).show();
            }
        });

        binding.editProfileEmailEtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "You cannot update your email.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @NotNull
    @Override
    public String getLoggerTag() {
        return "Edit profile";
    }
}