package com.seventeam.gsf.domain;

import com.seventeam.gsf.models.enums.EnumUsuarioPerfil;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

	@OneToOne(mappedBy = "usuario")
	private Medico medico;

//	@OneToMany(mappedBy="usuario", cascade = CascadeType.ALL)
//	private List<Permissao> permissaoList = new ArrayList<>();


	public Usuario() {
		this(null,null,EnumUsuarioPerfil.DESCONHECIDO);
	}

	public Usuario(String login, String password, EnumUsuarioPerfil perfil) {
		this.login = login;
		if (this.login == null || this.login.isEmpty()){
			this.login = "admin";
		}

		this.password = password;
		if (this.password == null || this.password.isEmpty()){
			this.password = "admin";
		}

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

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

//	public List<Permissao> getPermissaoList() {
//		return permissaoList;
//	}
//
//	public void setPermissaoList(List<Permissao> permissaoList) {
//		this.permissaoList = permissaoList;
//	}
}

