package com.seventeam.gsf.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.seventeam.gsf.models.enums.EnumUsuarioPerfil;

import javax.persistence.*;
import java.util.Date;

//@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Entity
@Table(name = "paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;

	@Column(name="nome")
	private String nome;

	@Column(name="data_nascimento")
	private Date dataNascimento;

	@Column(name="data_gravidez")
	private Date dataGravidez;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;


	public Paciente() {
	}

	public Paciente(String nome, Date dataNascimento, Date dataGravidez, Usuario usuario) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.dataGravidez = dataGravidez;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
