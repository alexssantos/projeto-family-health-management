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


	// =======================
	// RELATIONSHIPS
	// =======================
	/* We also need to place the @OneToOne annotation here, too. That's because this is a bidirectional relationship.
	 * The 'USAURIO' side of the relationship is called the non-owning side.
	 * */

	@OneToOne(mappedBy = "usuario")
	private Medico medico;

	@OneToOne(mappedBy = "usuario")
	private Paciente paciente;

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "perfil_id", referencedColumnName = "id")
	private Perfil perfil;


	// =======================
	// CONSTRUCTOR
	// =======================

	public Usuario(EnumUsuarioPerfil tipoPerfil) {
		this(null,null, tipoPerfil);
	}

	public Usuario() {
	}

	public Usuario(String login, String password, EnumUsuarioPerfil tipoPerfil) {
		this.login = login;
		if (this.login == null || this.login.isEmpty()){
			this.login = "admin";
		}

		this.password = password;
		if (this.password == null || this.password.isEmpty()){
			this.password = "admin";
		}

		// TODO: preciso que pegue o pefil ja existente e não que crie outro registro.
		this.perfil = new Perfil(tipoPerfil);
	}


	// GET SET
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

	public Perfil getPerfil() {
		return perfil;
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

}

