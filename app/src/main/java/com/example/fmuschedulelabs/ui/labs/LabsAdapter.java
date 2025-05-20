package com.example.fmuschedulelabs.ui.labs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fmuschedulelabs.R;
import com.example.fmuschedulelabs.data.model.Lab;

import java.util.List;

public class LabsAdapter extends RecyclerView.Adapter<LabsAdapter.LabViewHolder> {
    private List<Lab> labs;
    private OnAgendarClickListener agendarClickListener;

    public LabsAdapter(List<Lab> labs) {
        this.labs = labs;
    }

    @NonNull
    @Override
    public LabViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lab, parent, false);
        return new LabViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LabViewHolder holder, int position) {
        Lab lab = labs.get(position);
        holder.endereco.setText(lab.getEndereco());
        holder.andar.setText(lab.getAndar());
        holder.sala.setText(lab.getSala());
        holder.data.setText(lab.getDataDisponivel());
        holder.horario.setText(lab.getHorarioDisponivel());

        holder.buttonAgendar.setOnClickListener(v -> {
            if (agendarClickListener != null) {
                agendarClickListener.onAgendarClick(lab);
            }
        });
    }

    @Override
    public int getItemCount() {
        return labs != null ? labs.size() : 0;
    }

    public void setOnAgendarClickListener(OnAgendarClickListener listener) {
        this.agendarClickListener = listener;
    }

    public interface OnAgendarClickListener {
        void onAgendarClick(Lab lab);
    }

    public static class LabViewHolder extends RecyclerView.ViewHolder {
        TextView endereco, andar, sala, data, horario;
        Button buttonAgendar;

        public LabViewHolder(@NonNull View itemView) {
            super(itemView);
            endereco = itemView.findViewById(R.id.tvEndereco);
            andar = itemView.findViewById(R.id.tvAndar);
            sala = itemView.findViewById(R.id.tvSala);
            data = itemView.findViewById(R.id.tvData);
            horario = itemView.findViewById(R.id.tvHorario);
            buttonAgendar = itemView.findViewById(R.id.buttonAgendar);
        }
    }
}
