package com.example.helpyouout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Edit_Profile_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__profile_2);

        Button savebt = findViewById(R.id.edit_profile_save_bt);
        savebt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Edit_Profile_2.this,Edit_Profile.class));
            }
        });

        ImageButton backepbt = findViewById(R.id.backep2bt);
        backepbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Edit_Profile_2.this,Edit_Profile.class));

            }
        });
    }
}