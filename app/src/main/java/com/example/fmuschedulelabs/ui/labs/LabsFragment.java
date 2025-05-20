package com.example.fmuschedulelabs.ui.labs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fmuschedulelabs.R;
import com.example.fmuschedulelabs.data.db.LabDbHelper;
import com.example.fmuschedulelabs.data.model.Lab;

import java.util.List;

public class LabsFragment extends Fragment {

    private RecyclerView recyclerView;
    private LabsAdapter adapter;
    private LabDbHelper dbHelper;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_labs, container, false);

        recyclerView = root.findViewById(R.id.recyclerViewLabs);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        dbHelper = new LabDbHelper(getContext());
        List<Lab> labs = dbHelper.getAllLabs();

        adapter = new LabsAdapter(labs);
        recyclerView.setAdapter(adapter);

        adapter.setOnAgendarClickListener(lab -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("labSelecionado", lab);

            NavHostFragment.findNavController(this)
                    .navigate(R.id.navigation_scheduling, bundle);
            //Toast.makeText(getContext(), "Agendando laboratório: " + lab.getEndereco(), Toast.LENGTH_SHORT).show();
        });

        return root;
    }
}