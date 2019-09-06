package com.seventeam.gsf.domain;

import com.seventeam.gsf.models.enums.EnumUsuarioPerfil;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "login")
	private String login;

	@Column(name = "senha")
	private String password;

	@Column(name = "perfil")
	private EnumUsuarioPerfil perfil;

	@OneToOne(mappedBy = "usuario")
	private Paciente paciente;


	public Usuario(String login, String password, EnumUsuarioPerfil perfil) {
		this.login = login;
		this.password = password;
		this.perfil = perfil;
	}

	public Integer getId() {
		return id;
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

	public EnumUsuarioPerfil getPerfil() {
		return perfil;
	}

	public void setPerfil(EnumUsuarioPerfil perfil) {
		this.perfil = perfil;
	}
}

