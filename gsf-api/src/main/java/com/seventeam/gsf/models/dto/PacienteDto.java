package com.seventeam.gsf.models.dto;

import com.seventeam.gsf.domain.Paciente;

import java.io.Serializable;
import java.util.Date;

public class PacienteDto implements Serializable {

    private String name;
    private Date dataNascimento;
    private Date dataGravidez;
    private String login;
    private String senha;
    private String perfil;

    public PacienteDto() {
    }

    public PacienteDto(Paciente obj) {
        this.name = obj.getNome();
        this.dataGravidez = obj.getDataGravidez();
        this.dataNascimento = obj.getDataNascimento();
        this.login = obj.getUsuario().getLogin();
        this.senha = obj.getUsuario().getPassword();
        this.perfil = obj.getUsuario().getPerfil().getTipoPerfil().toString();
    }

    public PacienteDto(String name, Date dataNascimento, Date dataGravidez, String login, String senha) {
        this.name = name;
        this.dataNascimento = dataNascimento;
        this.dataGravidez = dataGravidez;
        this.login = login;
        this.senha = senha;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
