package com.seventeam.gsf.models.Form;

import com.seventeam.gsf.models.AbstractUsuario;

import java.io.Serializable;
import java.util.Date;

public class PacienteForm extends AbstractUsuario implements Serializable {

    public String nome;
    public Date dataNascimento;
    public Date dataGravidez;

    
    public PacienteForm(String password, String login, String nome, Date dataNascimento, Date dataGravidez) {
        super(password, login);
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.dataGravidez = dataGravidez;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataGravidez() {
        return dataGravidez;
    }

    public void setDataGravidez(Date dataGravidez) {
        this.dataGravidez = dataGravidez;
    }
}
