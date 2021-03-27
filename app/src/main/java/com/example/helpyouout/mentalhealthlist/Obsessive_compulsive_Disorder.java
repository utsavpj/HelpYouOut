package com.example.helpyouout.mentalhealthlist;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helpyouout.R;

public class Obsessive_compulsive_Disorder extends AppCompatActivity {
    Button pop_close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ml_obsessive_compulsive__disorder);


        pop_close = (Button) findViewById(R.id.pop_close);
        pop_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int hight = dm.heightPixels;

        getWindow().setLayout((int)(width*.8), (int)(hight*.7));

        WindowManager.LayoutParams params =getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        params.x = 0;
        params.y = -20;

        getWindow().setAttributes(params);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            if(bundle.getString("some") != null){
                Toast.makeText(getApplicationContext(), "data"+ bundle.getString("some"), Toast.LENGTH_SHORT).show();
            }
        }
    }
}