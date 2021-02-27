package com.example.helpyouout.main.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helpyouout.R;
import com.example.helpyouout.adapter.HomeMenuAdapter;
import com.example.helpyouout.databinding.FragmentHomeBinding;
import com.example.helpyouout.main.Fragment.BaseFragment;
import com.example.helpyouout.model.HomeMenuModel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class HomeFragment extends BaseFragment {

    FragmentHomeBinding binding;
    HomeMenuAdapter homeMenuAdapter;
    ArrayList<HomeMenuModel> menuItems;


    @NotNull
    @Override
    public View setContentView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @Override
    public void init() {

        menuItems = new ArrayList<>();
        menuItems.add(new HomeMenuModel("Meditation", R.drawable.meditation));
        menuItems.add(new HomeMenuModel("Scorecard", R.drawable.scorecard));
        menuItems.add(new HomeMenuModel("Tell your problems", R.drawable.chatbot));
        menuItems.add(new HomeMenuModel("Mental health list", R.drawable.mental_health_list_png));

        homeMenuAdapter = new HomeMenuAdapter(mContext, menuItems);

        binding.gridLayout.setAdapter(homeMenuAdapter);
    }

    @Override
    public void buttonClicks() {

    }
}
