package com.example.helpyouout.main.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.helpyouout.R;
import com.example.helpyouout.databinding.FragmentHomeBinding;
import com.example.helpyouout.databinding.FragmentMentalhealthlistBinding;
import com.example.helpyouout.mentalhealthlist.Anger;
import com.example.helpyouout.mentalhealthlist.Anxiety_and_Panic_attacks;
import com.example.helpyouout.mentalhealthlist.Bipolar_Disorder;
import com.example.helpyouout.mentalhealthlist.Body_Dysmorphic_Disorder;
import com.example.helpyouout.mentalhealthlist.Borderline_Personality;
import com.example.helpyouout.mentalhealthlist.Depression;
import com.example.helpyouout.mentalhealthlist.Dissociation_and_Dissociative_Disorder;
import com.example.helpyouout.mentalhealthlist.Eating_Problems;
import com.example.helpyouout.mentalhealthlist.Hearing_Voices;
import com.example.helpyouout.mentalhealthlist.Hoarding;
import com.example.helpyouout.mentalhealthlist.Hypomania_and_mania;
import com.example.helpyouout.mentalhealthlist.Loneliness;
import com.example.helpyouout.mentalhealthlist.Obsessive_compulsive_Disorder;
import com.example.helpyouout.mentalhealthlist.Paranoia;
import com.example.helpyouout.mentalhealthlist.Personality_Disorder;
import com.example.helpyouout.mentalhealthlist.Phobias;
import com.example.helpyouout.mentalhealthlist.Recreational_drugs_and_Alcohol;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MentalHealthListFragment extends BaseFragment {

    FragmentMentalhealthlistBinding binding;

    TextView anger,anxiety_and_panic_attacks,bipolar_disorder,body_dysmorphic_disorder,borderline_personality,depression,dissociation_and_dissociative_disorder,
            recreational_drugs_and_alcohol,eating_problems,hearing_voices,hoarding,hypomania_and_mania,loneliness,obsessive_compulsive_disorder,
            paranoia,personality_disorder,phobias;


    @NotNull
    @Override
    public View setContentView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container) {
        binding = FragmentMentalhealthlistBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }

    @androidx.annotation.Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @androidx.annotation.Nullable ViewGroup container, @androidx.annotation.Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mentalhealthlist,container,false);

        anger = view.findViewById(R.id.angertv);

        anger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Anger.class);
                startActivity(intent);
            }
        });
        anxiety_and_panic_attacks = view.findViewById(R.id.anxiety_and_panic_attackstv);

        anxiety_and_panic_attacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Anxiety_and_Panic_attacks.class);
                startActivity(intent);
            }
        });
        bipolar_disorder = view.findViewById(R.id.bipolar_disordertv);

        bipolar_disorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Bipolar_Disorder.class);
                startActivity(intent);
            }
        });
        body_dysmorphic_disorder = view.findViewById(R.id.body_dysmorphic_disordertv);

        body_dysmorphic_disorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Body_Dysmorphic_Disorder.class);
                startActivity(intent);
            }
        });
        borderline_personality = view.findViewById(R.id.borderline_personalitytv);

        borderline_personality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Borderline_Personality.class);
                startActivity(intent);
            }
        });
        depression = view.findViewById(R.id.depressiontv);

        depression.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Depression.class);
                startActivity(intent);
            }
        });
        dissociation_and_dissociative_disorder = view.findViewById(R.id.dissociation_and_dissociative_disordertv);

        dissociation_and_dissociative_disorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Dissociation_and_Dissociative_Disorder.class);
                startActivity(intent);
            }
        });
        recreational_drugs_and_alcohol = view.findViewById(R.id.recreational_drugs_and_alcoholtv);

        recreational_drugs_and_alcohol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Recreational_drugs_and_Alcohol.class);
                startActivity(intent);
            }
        });
        eating_problems = view.findViewById(R.id.eating_problemstv);

        eating_problems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Eating_Problems.class);
                startActivity(intent);
            }
        });
        hearing_voices = view.findViewById(R.id.hearing_voicestv);

        hearing_voices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Hearing_Voices.class);
                startActivity(intent);
            }
        });
        hoarding = view.findViewById(R.id.hoardingtv);

        hoarding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Hoarding.class);
                startActivity(intent);
            }
        });
        hypomania_and_mania = view.findViewById(R.id.hypomania_and_maniatv);

        hypomania_and_mania.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Hypomania_and_mania.class);
                startActivity(intent);
            }
        });
        loneliness = view.findViewById(R.id.lonelinesstv);

        loneliness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Loneliness.class);
                startActivity(intent);
            }
        });
        obsessive_compulsive_disorder = view.findViewById(R.id.obsessive_compulsive_disordertv);

        obsessive_compulsive_disorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Obsessive_compulsive_Disorder.class);
                startActivity(intent);
            }
        });
        paranoia = view.findViewById(R.id.paranoiatv);

        paranoia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Paranoia.class);
                startActivity(intent);
            }
        });
        personality_disorder = view.findViewById(R.id.personality_disordertv);

        personality_disorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Personality_Disorder.class);
                startActivity(intent);
            }
        });
        phobias = view.findViewById(R.id.phobiastv);

        phobias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), Phobias.class);
                startActivity(intent);
            }
        });
        return view;

    }

    @Override
    public void init() {

    }

    @Override
    public void buttonClicks() {

    }
}
