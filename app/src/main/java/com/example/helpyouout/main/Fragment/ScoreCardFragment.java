package com.example.helpyouout.main.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helpyouout.R;
import com.example.helpyouout.databinding.FragmentHomeBinding;
import com.example.helpyouout.databinding.FragmentScorecardBinding;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class ScoreCardFragment extends BaseFragment {

    FragmentScorecardBinding binding;

    @NotNull
    @Override
    public View setContentView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container) {
        binding = FragmentScorecardBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void init() {

    }

    @Override
    public void buttonClicks() {

    }
}
