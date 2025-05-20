package com.example.fmuschedulelabs.data.model;

import java.io.Serializable;

public class Scheduled implements Serializable {
    private String endereco;
    private String andar;
    private String sala;
    private String dataDisponivel;
    private String horarioDisponivel;
    private String agendadoPor;
    private String agendadoEm;

    public Scheduled(String endereco, String andar, String sala, String dataDisponivel, String horarioDisponivel, String agendadoPor, String agendadoEm) {
        this.endereco = endereco;
        this.andar = andar;
        this.sala = sala;
        this.dataDisponivel = dataDisponivel;
        this.horarioDisponivel = horarioDisponivel;
        this.agendadoPor = agendadoPor;
        this.agendadoEm = agendadoEm;
    }

    public Scheduled(String endereco, String andar, String sala, String dataDisponivel, String horarioDisponivel, String agendadoPor) {
        this.endereco = endereco;
        this.andar = andar;
        this.sala = sala;
        this.dataDisponivel = dataDisponivel;
        this.horarioDisponivel = horarioDisponivel;
        this.agendadoPor = agendadoPor;
    }

    public String getEndereco() { return endereco; }
    public String getAndar() { return andar; }
    public String getSala() { return sala; }
    public String getDataDisponivel() { return dataDisponivel; }
    public String getHorarioDisponivel() { return horarioDisponivel; }
    public String getAgendadoPor() { return agendadoPor; }
    public String getCriadoPor() { return agendadoEm; }

}
