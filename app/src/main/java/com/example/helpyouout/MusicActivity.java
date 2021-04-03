package com.example.helpyouout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.helpyouout.databinding.ActivityMusicBinding;
import com.example.helpyouout.main.BaseActivity;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static com.example.helpyouout.constants.AppHeart.APP_BASE_URL;


public class MusicActivity extends BaseActivity {

    ActivityMusicBinding binding;
    MediaPlayer mediaPlayer;
    Timer timer = new Timer();

    @NotNull
    @Override
    public View setContentView() {
        binding = ActivityMusicBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void init() {
        final ProgressDialog dialog = ProgressDialog.show(context, "Preparing", "Making environment ready...");

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build());

        try {
            mediaPlayer.setDataSource(APP_BASE_URL + "static/" + "RelaxingMusic.mp3");
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                dialog.dismiss();
                binding.btnPlayPause.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_baseline_play_circle_filled_24));
                binding.mediaplayerSeekbar.setMax(mediaPlayer.getDuration());

                binding.tvFullTime.setText(getMinutesFromDuration(mediaPlayer.getDuration()));
            }
        });

        mediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
                System.out.println("Buffering: " + i);
            }
        });
    }

    @Override
    public void buttonClicks() {
        binding.btnPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleMusic();
            }
        });

    }

    void toggleMusic() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();

            binding.btnPlayPause.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_baseline_play_circle_filled_24));
        } else {
            mediaPlayer.start();
            updateTime();
            binding.btnPlayPause.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_baseline_pause_circle_filled_24));
        }
    }

    void stopMusic() {
        try {
            mediaPlayer.stop();
            mediaPlayer.reset();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            mediaPlayer.pause();
            binding.btnPlayPause.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_baseline_play_circle_filled_24));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        try {
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
                binding.btnPlayPause.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_baseline_pause_circle_filled_24));
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onStop() {
        super.onStop();

        try {
            stopMusic();
            binding.btnPlayPause.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_baseline_play_circle_filled_24));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } finally {
            mediaPlayer = null;
        }
    }

    @NotNull
    @Override
    public String getLoggerTag() {
        return "Streaming music";
    }

    void updateTime() {

        if (timer == null) {
            timer = new Timer();
        }

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                            binding.tvCurrentTime.post(new Runnable() {
                                @Override
                                public void run() {
                                    binding.tvCurrentTime.setText(getMinutesFromDuration(mediaPlayer.getCurrentPosition()));
                                }
                            });
                        } else {
                            timer.cancel();
                            timer.purge();
                            timer = null;
                        }
                    }
                });
            }
        }, 0, 1000);
    }

    String getMinutesFromDuration(int duration) {
        return String.format("%02d:%02d",
                TimeUnit.MILLISECONDS.toMinutes(duration),
                TimeUnit.MILLISECONDS.toSeconds(duration) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration))
        );
    }

}