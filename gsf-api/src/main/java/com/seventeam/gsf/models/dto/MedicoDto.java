package com.seventeam.gsf.models.dto;

import com.seventeam.gsf.domain.Medico;

public class MedicoDto {
    private Integer id;
    private String crm;
    private String nome;
    private String usuario;

    public MedicoDto(Medico obj) {
        this.id = id;
        this.crm = crm;
        this.nome = nome;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
