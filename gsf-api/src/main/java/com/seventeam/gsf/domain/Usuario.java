package com.seventeam.gsf.domain;

import com.seventeam.gsf.models.enums.EnumUsuarioPerfil;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;

	@Column(name = "login")
	private String login;

	@Column(name = "senha")
	private String password;

	@Column(name = "perfil")
	private String perfil;

	@OneToOne(mappedBy = "usuario")
	private Paciente paciente;

	public Usuario() {
	}

	public Usuario(String login, String password, EnumUsuarioPerfil perfil) {
		this.login = login;
		this.password = password;
		this.perfil = perfil.toString();
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

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
}

