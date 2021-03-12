package com.example.helpyouout;

import android.view.View;
import android.view.animation.Animation;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.helpyouout.databinding.ActivityHomeBinding;
import com.example.helpyouout.main.BaseActivity;
import com.example.helpyouout.main.Fragment.ChatBotFragment;
import com.example.helpyouout.main.Fragment.HomeFragment;
import com.example.helpyouout.main.Fragment.MeditationFragment;
import com.example.helpyouout.main.Fragment.MentalHealthListFragment;
import com.example.helpyouout.main.Fragment.ScoreCardFragment;
import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BaseActivity {

    Class fragmentClass;
    public static Fragment fragment;
    private boolean isFabOpen = false;
//    private FloatingActionButton fab, editProfileFab, feedbackFab, logoutFab;
    private Animation fab_close, fab_open, rotate_backward, rotate_forward;


    ActivityHomeBinding binding;

    @NotNull
    @Override
    public View setContentView() {
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void init() {
        List<MenuItem> menuItems = new ArrayList<>();


        //Use the MenuItem given by this library and not the default one.
        //First parameter is the title of the menu item and then the second parameter is the image which will be the background of the menu item.
        menuItems.add(new MenuItem("Home", R.drawable.meditation));
        menuItems.add(new MenuItem("ScoreCard", R.drawable.news_bg));
        menuItems.add(new MenuItem("Meditation", R.drawable.feed_bg));
        menuItems.add(new MenuItem("Chat Bot", R.drawable.message_bg));
        menuItems.add(new MenuItem("Mental Health List", R.drawable.music_bg));

        //then add them to navigation drawer

        binding.navigationDrawer.setMenuItemList(menuItems);
        fragmentClass = HomeFragment.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.container, fragment).commit();
        }


        //Listener to handle the menu item click. It returns the position of the menu item clicked. Based on that you can switch between the fragments.

        binding.navigationDrawer.setOnMenuItemClickListener(new SNavigationDrawer.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClicked(int position) {
                System.out.println("Position " + position);

                switch (position) {
                    case 0: {
                        fragmentClass = HomeFragment.class;
                        break;
                    }
                    case 1: {
                        fragmentClass = ScoreCardFragment.class;
                        break;
                    }
                    case 2: {
                        fragmentClass = MeditationFragment.class;
                        break;
                    }
                    case 3: {
                        fragmentClass = Tell_Your_Problems.class;
                        break;
                    }
                    case 4: {
                        fragmentClass = MentalHealthListFragment.class;
                        break;
                    }

                }

                //Listener for drawer events such as opening and closing.
                binding.navigationDrawer.setDrawerListener(new SNavigationDrawer.DrawerListener() {

                    @Override
                    public void onDrawerOpened() {

                    }

                    @Override
                    public void onDrawerOpening() {

                    }

                    @Override
                    public void onDrawerClosing() {
                        System.out.println("Drawer closed");

                        try {
                            fragment = (Fragment) fragmentClass.newInstance();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        if (fragment != null) {
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            fragmentManager.beginTransaction()
                                    .setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out)
                                    .replace(R.id.container, fragment)
                                    .commit();

                        }
                    }

                    @Override
                    public void onDrawerClosed() {

                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        System.out.println("State " + newState);
                    }
                });
            }
        });

    }

    @Override
    public void buttonClicks() {

    }

    @NotNull
    @Override
    public String getLoggerTag() {
        return "HomeActivity";
    }
}


