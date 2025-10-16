package com.example.emotilog.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.emotilog.Logger;
import com.example.emotilog.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);

        // hook up all the buttons
        setupButton(binding.happyEmoticon);
        setupButton(binding.sadEmoticon);
        setupButton(binding.TiredEmoticon);
        setupButton(binding.InLoveEmoticon);
        setupButton(binding.ChillEmoticon);
        setupButton(binding.AngryEmoticon);

        return binding.getRoot();
    }

    private void setupButton(ImageButton button) {
        button.setOnClickListener(v -> {
            String emotion = (String) v.getContentDescription();
            Logger.log(emotion); // EMOTION USED HERE
            Toast.makeText(getContext(),
                    emotion + " clicked!", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
