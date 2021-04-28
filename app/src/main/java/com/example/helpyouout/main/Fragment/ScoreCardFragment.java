package com.example.helpyouout.main.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ApplicationClass;
import com.example.helpyouout.ScoreForMH;
import com.example.helpyouout.databinding.FragmentScorecardBinding;
import com.example.helpyouout.model.GetResultModel;
import com.example.helpyouout.model.ScoreItems;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

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
        final ProgressDialog dialog = ProgressDialog.show(mContext, "Loading", "Logging you in...");

        callWS().getResults(ApplicationClass.mInstance.getUserDetails().getData().getId().toString()).enqueue(new Callback<GetResultModel>() {
            @Override
            public void onResponse(Call<GetResultModel> call, Response<GetResultModel> response) {
                dialog.dismiss();

                if (response.isSuccessful() && response.body().getStatus()) {

                    List<ScoreItems> listOfScores = response.body().getData();

                    if (!listOfScores.isEmpty()) {
                        binding.testScore.setText(listOfScores.get(listOfScores.size() - 1).getScore().toString());


                        }
                    }

                }


            @Override
            public void onFailure(Call<GetResultModel> call, Throwable t) {
                dialog.dismiss();
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
