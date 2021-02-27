package com.example.helpyouout.main.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helpyouout.R;
import com.example.helpyouout.databinding.FragmentChatbotBinding;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ChatBotFragment extends BaseFragment {

    FragmentChatbotBinding binding;

    @NotNull
    @Override
    public View setContentView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container) {

        binding = FragmentChatbotBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void init() {

    }

    @Override
    public void buttonClicks() {

    }
}
