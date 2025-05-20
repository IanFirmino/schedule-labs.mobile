package com.example.fmuschedulelabs.data.model;

import java.io.Serializable;

public class Lab implements Serializable {
    private String endereco;
    private String andar;
    private String sala;
    private String dataDisponivel;
    private String horarioDisponivel;

    public Lab(String endereco, String andar, String sala, String dataDisponivel, String horarioDisponivel) {
        this.endereco = endereco;
        this.andar = andar;
        this.sala = sala;
        this.dataDisponivel = dataDisponivel;
        this.horarioDisponivel = horarioDisponivel;
    }

    // Getters
    public String getEndereco() { return endereco; }
    public String getAndar() { return andar; }
    public String getSala() { return sala; }
    public String getDataDisponivel() { return dataDisponivel; }
    public String getHorarioDisponivel() { return horarioDisponivel; }
}
