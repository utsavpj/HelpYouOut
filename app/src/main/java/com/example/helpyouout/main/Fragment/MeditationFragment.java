package com.example.helpyouout.main.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.helpyouout.Breathe;
import com.example.helpyouout.R;
import com.example.helpyouout.databinding.FragmentHomeBinding;
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
        TextView textView = currentView.findViewById(R.id.breathActivity);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Breathe.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void buttonClicks() {

    }
}
