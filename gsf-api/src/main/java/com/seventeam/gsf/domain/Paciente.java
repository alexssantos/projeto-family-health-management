package com.seventeam.gsf.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

//@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Entity
@Table(name = "paciente")
public class Paciente implements Serializable {

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

	// RELATIONSHIPS
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "usuario_id", referencedColumnName = "id")
	private Usuario usuario;

	//(OneToMany) Paceinte -> Procedimento


	public Paciente() {
	}

	public Paciente(String nome, Date dataNascimento, Date dataGravidez, Usuario usuario) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.dataGravidez = dataGravidez;
		this.usuario = usuario;

		if (this.usuario == null){
			this.usuario = new Usuario();
		}
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

	@Override
	public String toString() {
		return "\nPaciente{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", dataNascimento=" + dataNascimento +
				", dataGravidez=" + dataGravidez +
				", usuario=" + usuario +
				'}';
	}
}
