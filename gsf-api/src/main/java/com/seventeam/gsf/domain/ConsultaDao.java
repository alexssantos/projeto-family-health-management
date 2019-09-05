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
    private Long id;

    private String Tipo;
    private Date DataPrevista;
    private Date DataFeita;
    private Long Consulta_ID;

    public ConsultaDao() {
    }

    public ConsultaDao(String tipo, Date dataPrevista, Date dataFeita, Long consulta_ID) {
        Tipo = tipo;
        DataPrevista = dataPrevista;
        DataFeita = dataFeita;
        Consulta_ID = consulta_ID;
    }

    public Long getId() {
        return id;
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

    public Long getConsulta_ID() {
        return Consulta_ID;
    }

    public void setConsulta_ID(Long consulta_ID) {
        Consulta_ID = consulta_ID;
    }
}
