package com.example.helpyouout.main.Fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ApplicationClass;
import com.example.helpyouout.R;
import com.example.helpyouout.ScoreForMH;
import com.example.helpyouout.constants.AppHeart;
import com.example.helpyouout.databinding.FragmentHomeBinding;
import com.example.helpyouout.databinding.FragmentScorecardBinding;
import com.example.helpyouout.model.AllQuestionModel;
import com.example.helpyouout.model.Data;
import com.example.helpyouout.model.GetResult;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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

        callWS().result().enqueue(new Callback<GetResult>() {
            @Override
            public void onResponse(Call<GetResult> call, Response<GetResult> response) {
                if (response.isSuccessful() && response.body().getStatus()){
                    binding.testScore.setText(response.body().getData().getScore());
                }
            }

            @Override
            public void onFailure(Call<GetResult> call, Throwable t) {

            }
        });
     

    }

    @Override
    public void buttonClicks() {

        binding.measureHealth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ScoreForMH.class);
                startActivity(intent);
            }
        });

    }
}
