package com.example.fmuschedulelabs.ui.scheduled;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.fmuschedulelabs.databinding.FragmentScheduledBinding;

public class ScheduledFragment extends Fragment {

    private FragmentScheduledBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ScheduledViewModel dashboardViewModel =
                new ViewModelProvider(this).get(ScheduledViewModel.class);

        binding = FragmentScheduledBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textScheduled;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}