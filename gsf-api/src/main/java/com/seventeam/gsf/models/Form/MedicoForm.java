package com.seventeam.gsf.models.Form;

import com.seventeam.gsf.models.AbstractUsuario;

public class MedicoForm extends AbstractUsuario {
	
	private String nome;
	private String crm;
	
	public MedicoForm(String password, String login, String nome, String crm) {
		super(password, login);
		this.nome = nome;
		this.crm = crm;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCrm() {
		return crm;
	}
	
	public void setCrm(String crm) {
		this.crm = crm;
	}
}
