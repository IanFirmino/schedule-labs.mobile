package com.example.fmuschedulelabs.ui.scheduling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.fmuschedulelabs.databinding.FragmentSchedulingBinding;

public class SchedulingFragment extends Fragment {

    private FragmentSchedulingBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SchedulingViewModel notificationsViewModel =
                new ViewModelProvider(this).get(SchedulingViewModel.class);

        binding = FragmentSchedulingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textScheduling;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}