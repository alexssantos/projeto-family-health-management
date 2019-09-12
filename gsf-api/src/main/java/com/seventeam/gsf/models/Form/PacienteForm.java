package com.seventeam.gsf.models.Form;

import java.io.Serializable;
import java.util.Date;

public class PacienteForm implements Serializable {

    public String login;
    public String password;
    public String nome;
    public Date dataNascimento;
    public Date dataGravidez;

    public PacienteForm() {
    }

    public PacienteForm(String login, String password, String nome, Date dataNascimento, Date dataGravidez) {
        this.login = login;
        this.password = password;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.dataGravidez = dataGravidez;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
