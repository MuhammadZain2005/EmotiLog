package com.example.emotilog.ui.summary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.emotilog.Logger;
import com.example.emotilog.SummaryLogger;
import com.example.emotilog.databinding.FragmentSummaryBinding;

import java.util.List;

public class SummaryFragment extends Fragment {

    private FragmentSummaryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSummaryBinding.inflate(inflater, container, false);
        updateSummary();
        return binding.getRoot();
    }
    @Override
    public void onResume() {
        super.onResume();
        updateSummary();
    }
    private void updateSummary() {
        binding.happyCount.setText(String.valueOf(SummaryLogger.getCount("Happy")));
        binding.sadCount.setText(String.valueOf(SummaryLogger.getCount("Sad")));
        binding.angryCount.setText(String.valueOf(SummaryLogger.getCount("Angry")));
        binding.tiredCount.setText(String.valueOf(SummaryLogger.getCount("Tired")));
        binding.inloveCount.setText(String.valueOf(SummaryLogger.getCount("InLove")));
        binding.chillCount.setText(String.valueOf(SummaryLogger.getCount("Chill")));

        // total count
        binding.totalCount.setText("Total Count: " + SummaryLogger.getTotal());

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}