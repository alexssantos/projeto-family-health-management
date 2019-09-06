package com.seventeam.gsf.models.dto;

import com.seventeam.gsf.domain.Consulta;

import java.io.Serializable;
import java.util.Date;

public class ConsultaDto implements Serializable {

    private String Tipo;
    private Date DataFeita;

    public ConsultaDto() {
    }

    public ConsultaDto(Consulta obj){
        this.DataFeita = obj.getDataFeita();
        this.Tipo = obj.getTipo();
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public Date getDataFeita() {
        return DataFeita;
    }

    public void setDataFeita(Date dataFeita) {
        DataFeita = dataFeita;
    }
}
