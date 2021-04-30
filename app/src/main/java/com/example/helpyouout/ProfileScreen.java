package com.example.helpyouout;

import android.view.View;

import com.example.ApplicationClass;
import com.example.helpyouout.databinding.ActivityProfileBinding;
import com.example.helpyouout.main.BaseActivity;
import com.example.helpyouout.model.UserModel;

import org.jetbrains.annotations.NotNull;


public class ProfileScreen extends BaseActivity {

    ActivityProfileBinding binding;

    @NotNull
    @Override
    public View setContentView() {
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void init() {

        UserModel userModel = ApplicationClass.app.getUserDetails();
        if(userModel !=null){

            binding.editProfileName.setText(userModel.getData().getName());
            binding.editProfileEmail.setText(userModel.getData().getEmail());

            binding.editProfileGenderTv.setText(userModel.getData().getGender());
            binding.editProfileBirthdayTv.setText(userModel.getData().getDob());
        }
    }

    @Override
    public void buttonClicks() {

        binding.editProfileBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goWithFinish(EditProfile.class);
            }
        });

        binding.backep1bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @NotNull
    @Override
    public String getLoggerTag() {
        return "Profile screen";
    }
}