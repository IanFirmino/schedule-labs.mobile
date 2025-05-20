package com.example.fmuschedulelabs.ui.scheduling;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.fmuschedulelabs.R;
import com.example.fmuschedulelabs.data.db.ScheduledDbHelper;
import com.example.fmuschedulelabs.data.model.Lab;
import com.example.fmuschedulelabs.data.model.Scheduled;
import com.example.fmuschedulelabs.databinding.FragmentSchedulingBinding;
import com.example.fmuschedulelabs.ui.scheduled.ScheduledFragment;

public class SchedulingFragment extends Fragment {

    private FragmentSchedulingBinding binding;
    private Lab labSelecionado;  // <-- Torna-se atributo da classe

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSchedulingBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Bundle args = getArguments();
        if (args != null) {
            labSelecionado = (Lab) args.getSerializable("labSelecionado");  // <-- Atribuição ao atributo da classe
        }

        if (labSelecionado != null) {
            String info = "Endereço: " + labSelecionado.getEndereco() + "\n" +
                    "Andar: " + labSelecionado.getAndar() + "\n" +
                    "Sala: " + labSelecionado.getSala() + "\n" +
                    "Data: " + labSelecionado.getDataDisponivel() + "\n" +
                    "Horário: " + labSelecionado.getHorarioDisponivel();

            binding.textAgendamentoInfo.setText(info);
        } else {
            binding.textAgendamentoInfo.setText("Nenhum laboratório selecionado.");
        }

        binding.buttonFinalizar.setOnClickListener(v -> {
            String nome = binding.editTextNome.getText().toString().trim();

            if (nome.isEmpty()) {
                Toast.makeText(getContext(), "Por favor, insira seu nome.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(),
                        "Agendamento confirmado para " + nome,
                        Toast.LENGTH_LONG).show();

                Scheduled scheduled = new Scheduled(
                        labSelecionado.getEndereco(),
                        labSelecionado.getAndar(),
                        labSelecionado.getSala(),
                        labSelecionado.getDataDisponivel(),
                        labSelecionado.getHorarioDisponivel(),
                        nome
                );

                ScheduledDbHelper scheduledDbHelper = new ScheduledDbHelper(getContext());
                scheduledDbHelper.createScheduled(scheduled);

                ScheduledFragment scheduledFragment = new ScheduledFragment();

                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.nav_host_fragment_activity_main, scheduledFragment)
                        .commit();
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
