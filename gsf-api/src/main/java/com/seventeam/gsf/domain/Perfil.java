package com.seventeam.gsf.domain;

import com.seventeam.gsf.models.enums.EnumUsuarioPerfil;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

	@Enumerated(EnumType.STRING)
    @Column(name = "tipo", unique = true)
    private EnumUsuarioPerfil tipoPerfil;


    // RELATIONSHIOPS
    @OneToOne(mappedBy = "perfil")
    private Usuario usuario;

	@OneToMany(mappedBy="perfil", cascade = CascadeType.ALL)
	private  List<Permissao> permissaoList;



	// CONSTRUTOR
	public Perfil() {}

	public Perfil(EnumUsuarioPerfil tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }


    // GET SET
    public EnumUsuarioPerfil getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(EnumUsuarioPerfil tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    public List<Permissao> getPermissaoList() {
		return permissaoList;
	}

	public void setPermissaoList(ArrayList<Permissao> permissaoList) {
		this.permissaoList = permissaoList;
	}

}
