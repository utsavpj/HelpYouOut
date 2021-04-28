package com.example.helpyouout.main.Fragment;

import android.content.Intent;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ApplicationClass;
import com.example.helpyouout.Breathe;
import com.example.helpyouout.Edit_Profile;
import com.example.helpyouout.LoginScreen;
import com.example.helpyouout.R;
import com.example.helpyouout.adapter.HomeMenuAdapter;
import com.example.helpyouout.databinding.FragmentHomeBinding;
import com.example.helpyouout.main.Fragment.BaseFragment;
import com.example.helpyouout.model.HomeMenuModel;
import com.example.helpyouout.model.UserModel;

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
        menuItems.add(new HomeMenuModel("Mental health list", R.drawable.mentalhealth));

        homeMenuAdapter = new HomeMenuAdapter(mContext, menuItems);
        binding.gridLayout.setAdapter(homeMenuAdapter);


        binding.user.setText(ApplicationClass.app.getUserDetails().getData().getName());

    }

    @Override
    public void buttonClicks() {
        binding.logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApplicationClass.app.removeUser();
                goWithFinish(LoginScreen.class);
            }
        });

        binding.profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getActivity(), Edit_Profile.class);
                startActivity(intent);
            }
        });


    }
}
