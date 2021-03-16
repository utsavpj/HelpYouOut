package com.example.helpyouout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class Edit_Profile extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        Button editProfileBt = findViewById(R.id.edit_profile_bt);
        editProfileBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Edit_Profile.this,Edit_Profile_2.class));
            }
        });

        ImageButton backep1Bt = findViewById(R.id.backep1bt);

        backep1Bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Edit_Profile.this,HomeActivity.class));
            }
        });
    }
}