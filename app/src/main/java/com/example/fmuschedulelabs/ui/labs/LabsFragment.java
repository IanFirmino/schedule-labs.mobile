package com.example.fmuschedulelabs.ui.labs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.fmuschedulelabs.databinding.FragmentLabsBinding;

public class LabsFragment extends Fragment {

    private FragmentLabsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LabsViewModel homeViewModel =
                new ViewModelProvider(this).get(LabsViewModel.class);

        binding = FragmentLabsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textLabs;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}