package com.seventeam.gsf.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Entity
@Table(name = "paciente")
public class PacienteDao {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer ID;

	@Column(name="Nome")
	private String Nome;

	@Column(name="DataNascimento")
	private Date DataNascimento;

	@Column(name="DataGravidez")
	private Date DataGravidez;

	// OneToOne
	//@EmbeddedId
	//private UsuarioDao usuario;
}
