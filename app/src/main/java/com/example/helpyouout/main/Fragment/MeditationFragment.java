package com.example.helpyouout.main.Fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.helpyouout.Breathe;
import com.example.helpyouout.MusicActivity;
import com.example.helpyouout.databinding.FragmentMeditationBinding;

import org.jetbrains.annotations.NotNull;

public class MeditationFragment extends BaseFragment {

    FragmentMeditationBinding binding;

    @NotNull
    @Override
    public View setContentView(@NotNull LayoutInflater inflater, @org.jetbrains.annotations.Nullable ViewGroup container) {

        binding = FragmentMeditationBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void init() {
        binding.breatheCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getActivity(), Breathe.class);
                startActivity(intent);
            }
        });

        binding.musicCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 =  new Intent(getActivity(), MusicActivity.class);
                startActivity(intent2);
            }
        });
    }

    @Override
    public void buttonClicks() {

    }
}
