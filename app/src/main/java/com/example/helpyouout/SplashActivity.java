package com.example.helpyouout;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;

import com.example.helpyouout.databinding.ActivitySplashBinding;
import com.example.helpyouout.main.BaseActivity;

import org.jetbrains.annotations.NotNull;

public class SplashActivity extends BaseActivity {

    @NotNull
    @Override
    public View setContentView() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return ActivitySplashBinding.inflate(getLayoutInflater()).getRoot();
    }

    @Override
    public void init() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, LoginScreen.class));
                finish();
            }
        }, 1500);
    }

    @Override
    public void buttonClicks() {

    }

    @NotNull
    @Override
    public String getLoggerTag() {
        return "SplashActivity";
    }
}