package com.seventeam.gsf.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

//@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
@Entity
@Table(name = "paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="nome")
	private String nome;

	@Column(name="data_nascimento")
	private Date dataNascimento;

	@Column(name="data_gravidez")
	private Date dataGravidez;

	@EmbeddedId
	@Column(name="usuario_id")
	private Usuario usuario;
}
