package com.example.helpyouout.main.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;

import com.example.helpyouout.Breathe;
import com.example.helpyouout.MusicActivity;
import com.example.helpyouout.R;

public class MeditationFragment extends BaseFragment {

    @Override
    public int setContentView() {
        return R.layout.fragment_meditation;
    }

    @Override
    public void init() {
        CardView breatheCard = currentView.findViewById(R.id.breatheCard);
        breatheCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Breathe.class);
                startActivity(intent);
            }
        });
        CardView musicCard = currentView.findViewById(R.id.musicCard);
        musicCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MusicActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void buttonClicks() {


    }
}
