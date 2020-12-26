package com.example.helpyouout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helpyouout.utli.breatheSharedPref;
import com.github.florent37.viewanimator.AnimationListener;
import com.github.florent37.viewanimator.ViewAnimator;

import java.text.MessageFormat;


public class Breathe extends AppCompatActivity {
    private ImageView breathImage;
    private TextView lastTimeUsed;
    private TextView breathCounter;
    private TextView breathToday;
    private TextView breathText;
    private Button startBtn;
    private breatheSharedPref breatheSharedPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathe);

        breathImage = findViewById(R.id.breathDemo);
        lastTimeUsed= findViewById(R.id.lasttimeused);
        breathCounter=findViewById(R.id.breathCounter);
        breathToday = findViewById(R.id.breathtoday);
        breathText = findViewById(R.id.breathtxt);
        startBtn = findViewById(R.id.startbtn);
        breatheSharedPref = new breatheSharedPref(this);

        ViewAnimator
                .animate(breathImage)
                .translationY(-1000, 0)
                .alpha(0,1)
                // .andAnimate(breathText)
                .dp().translationX(-20, 0)
                .decelerate()
                .duration(2000)
                .thenAnimate(breathImage)
                .scale(1f, 0.5f, 1f)
                .rotation(270)
                .repeatCount(4)
                .accelerate()
                .duration(1000)
                .start();

        startIntroAnimation();

        breathToday.setText(MessageFormat.format("{0} min today",breatheSharedPref.getSessions()));
        breathCounter.setText(MessageFormat.format("{0} breathe",breatheSharedPref.getBreathe()));
        lastTimeUsed.setText(breatheSharedPref.getDate());


        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });
    }
    public void startIntroAnimation(){
        ViewAnimator
                .animate(breathText)
                .scale(0,1)
                .duration(1500)
                .onStart(new AnimationListener.Start() {
                    @Override
                    public void onStart() {
                        breathText.setText("Breathe");
                    }
                }).start();
    }
    private void startAnimation(){
        ViewAnimator
                .animate(breathImage)
                .scale(0,1)
                .duration(1500)
                .onStart(new AnimationListener.Start() {
                    @Override
                    public void onStart() {
                        breathText.setText("Inhale ... Exhale");
                    }
                }).decelerate()
                .duration(1000)
                .thenAnimate(breathImage)
                .scale(0.02f,1.5f,0.02f)
                .rotation(360)
                .repeatCount(6)
                .accelerate()
                .duration(5000)
                .onStop(new AnimationListener.Stop() {
                    @Override
                    public void onStop() {
                        breathText.setText("Well Done!");
                        breathImage.setScaleX(1.0f);
                        breathImage.setScaleY(1.0f);

                        breatheSharedPref.setBreathe(breatheSharedPref.getBreathe()+1);
                        breatheSharedPref.setSessions(breatheSharedPref.getSessions()+1);
                        breatheSharedPref.setDate(System.currentTimeMillis());

                        //To refresh the breathe activity
                        new CountDownTimer(2000,1000){
                            @Override
                            public void onTick(long millisUntilFinished) {
                                //to tick like 3..2..1
                            }

                            @Override
                            public void onFinish() {
                              startActivity(new Intent(getApplicationContext(),Breathe.class));
                            }
                        }.start();
                    }
                }).start();
    }
    }
