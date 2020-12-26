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

public class MeditationFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meditation,container,false);
        //CardView breatheCard =view.findViewById(R.id.breatheCard);

        return view;
    }

    @Override
    public int setContentView() {
        return R.layout.fragment_meditation;
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
