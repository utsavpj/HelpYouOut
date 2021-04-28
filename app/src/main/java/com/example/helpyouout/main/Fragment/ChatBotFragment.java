package com.example.helpyouout.main.Fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helpyouout.LoginScreen;
import com.example.helpyouout.R;
import com.example.helpyouout.SignUpStage1;
import com.example.helpyouout.Tell_Your_Problems;
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

        binding.clickHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Tell_Your_Problems.class));
            }
        });

    }
}
