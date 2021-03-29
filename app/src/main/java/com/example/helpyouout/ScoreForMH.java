package com.example.helpyouout;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.helpyouout.databinding.ActivityScoreForMHBinding;
import com.example.helpyouout.main.BaseActivity;
import com.example.helpyouout.model.AllQuestionModel;
import com.example.helpyouout.model.QuestionData;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScoreForMH extends BaseActivity {

    ActivityScoreForMHBinding binding;
    AllQuestionModel allQuestionModel;
    int index = 0;

    int score = 0;


    @NotNull
    @Override
    public View setContentView() {
        binding = ActivityScoreForMHBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void init() {

        final ProgressDialog dialog = ProgressDialog.show(context, "Loading", "Fetching questions...");


        callWS().testQuestion().enqueue(new Callback<AllQuestionModel>() {
            @Override
            public void onResponse(Call<AllQuestionModel> call, Response<AllQuestionModel> response) {

                dialog.dismiss();

                if (response.isSuccessful() && response.body().getStatus()) {
                    allQuestionModel = response.body();

                    setQuestions();

                } else {
                    Toast.makeText(context, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AllQuestionModel> call, Throwable t) {

                dialog.dismiss();

                Toast.makeText(context, "Something went wrong.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void buttonClicks() {

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (binding.optionsGroup.getCheckedRadioButtonId() > -1) {


                    QuestionData questionData = allQuestionModel.getData().get(index);

                    switch (binding.optionsGroup.getCheckedRadioButtonId()) {
                        case 0:
                            score = score + Integer.parseInt(questionData.getValue1());
                            break;
                        case 1:
                            score = score + Integer.parseInt(questionData.getValue2());
                            break;
                        case 2:
                            score = score + Integer.parseInt(questionData.getValue3());
                            break;
                        case 3:
                            score = score + Integer.parseInt(questionData.getValue4());
                            break;
                    }

                    index++;
                    setQuestions();

                } else {
                    Toast.makeText(context, "Please select valid option", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

    @NotNull
    @Override
    public String getLoggerTag() {
        return null;
    }

    void setQuestions() {

        if (index + 1 == allQuestionModel.getData().size()) {
            binding.btnNext.setText("Finish");
        } else {
            binding.btnNext.setText("Next");
        }

        if (index >= allQuestionModel.getData().size()) {

            new AlertDialog.Builder(context).setTitle("Your score")
                    .setMessage("Your final mental health score is :" + score)
                    .setCancelable(false)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    }).show();


            return;
        }


        QuestionData questionData = allQuestionModel.getData().get(index);
        binding.txtQuestion.setText(questionData.getQuestion());

        inflateOptions(questionData);
    }


    void inflateOptions(QuestionData questionData) {
        binding.optionsGroup.removeAllViews();

        for (int i = 0; i < 4; i++) {
            RadioButton radioButton = new RadioButton(context);

            radioButton.setId(i);

            switch (i) {
                case 0:
                    radioButton.setText(questionData.getOption1());
                    break;
                case 1:
                    radioButton.setText(questionData.getOption2());
                    break;
                case 2:
                    radioButton.setText(questionData.getOption3());
                    break;
                case 3:
                    radioButton.setText(questionData.getOption4());
                    break;
            }

            binding.optionsGroup.addView(radioButton);
        }


    }

}