package com.seventeam.gsf.models.Form;

public class PermissaoForm {
	
	private String acao;
	private String tipoPerfil;
	
	public PermissaoForm() {
	}
	
	public PermissaoForm(String acao, String tipoPerfil) {
		this.acao = acao;
		this.tipoPerfil = tipoPerfil;
	}
	
	public String getAcao() {
		return acao;
	}
	
	public void setAcao(String acao) {
		this.acao = acao;
	}
	
	public String getTipoPerfil() {
		return tipoPerfil;
	}
	
	public void setTipoPerfil(String tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}
}
