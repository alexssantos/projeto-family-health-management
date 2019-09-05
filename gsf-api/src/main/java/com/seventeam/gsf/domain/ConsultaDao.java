package com.seventeam.gsf.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Entity
@Table(name = "consulta")
public class ConsultaDao implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer ID;

    @Column(name="Tipo")
    private String Tipo;

    @Column(name="DataPrevista")
    private Date DataPrevista;

    @Column(name="DataFeita")
    private Date DataFeita;

    @ManyToOne
    @JoinColumn(name="Paciente_ID")
    private PacienteDao Paciente;

    public ConsultaDao() {
    }

    public ConsultaDao(String tipo, Date dataPrevista, Date dataFeita, PacienteDao paciente_ID) {
        Tipo = tipo;
        DataPrevista = dataPrevista;
        DataFeita = dataFeita;
        Paciente = paciente_ID;
    }

    public Integer getID() {
        return ID;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public Date getDataPrevista() {
        return DataPrevista;
    }

    public void setDataPrevista(Date dataPrevista) {
        DataPrevista = dataPrevista;
    }

    public Date getDataFeita() {
        return DataFeita;
    }

    public void setDataFeita(Date dataFeita) {
        DataFeita = dataFeita;
    }

    public PacienteDao getPaciente() {
        return Paciente;
    }

    public void setPaciente(PacienteDao paciente) {
        Paciente = paciente;
    }
}
