package com.example.emotilog.ui.Logs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.emotilog.databinding.FragmentLogsBinding;
import com.example.emotilog.Logger;
public class LogsFragment extends Fragment {

    private FragmentLogsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentLogsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Text view bind
        TextView loggerText = binding.loggerText;

        // Build one string from all logs
        StringBuilder sb = new StringBuilder();
        for (String event : Logger.getAll()) {
            sb.append(event).append("\n");
        }
        // Show it
        loggerText.setText(sb.toString());
        return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}