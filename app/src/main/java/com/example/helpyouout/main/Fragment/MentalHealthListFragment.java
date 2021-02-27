package com.example.helpyouout.main.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.helpyouout.R;
import com.example.helpyouout.databinding.FragmentHomeBinding;
import com.example.helpyouout.databinding.FragmentMentalhealthlistBinding;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MentalHealthListFragment extends BaseFragment {

    FragmentMentalhealthlistBinding binding;

    @NotNull
    @Override
    public View setContentView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container) {
        binding = FragmentMentalhealthlistBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void init() {

    }

    @Override
    public void buttonClicks() {

    }
}
