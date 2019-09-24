package com.seventeam.gsf.domain;

import com.seventeam.gsf.models.enums.PerfilTipoEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "perfil")
public class Perfil {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

	@Enumerated(EnumType.STRING)
    @Column(name = "tipo", unique = true)
    private PerfilTipoEnum tipoPerfil;

	public static List<Perfil> allPerfis = new ArrayList<>();


    // =======================
    // RELATIONSHIPS
    // =======================
    /* We also need to place the @OneToOne annotation here, too. That's because this is a bidirectional relationship.
     * The 'PERFIL' side of the relationship is called the non-owning side.
     */
//
//    @OneToMany(mappedBy = "perfil", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<Usuario> usuarioList = new ArrayList<>();


    // =======================
    // CONSTRUCTOR
    // =======================

	public Perfil() {}

	public Perfil(PerfilTipoEnum tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

    public Perfil(Integer id, PerfilTipoEnum tipoPerfil) {
        this.id = id;
	    this.tipoPerfil = tipoPerfil;
    }


    // =======================
    // GET SET
    // =======================

    public Integer getId() {
        return id;
    }

    public PerfilTipoEnum getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(PerfilTipoEnum tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

//    public List<Usuario> getUsuarioList() {
//        return usuarioList;
//    }
//
//    public void setUsuarioList(ArrayList<Usuario> usuarioList) {
//        this.usuarioList = usuarioList;
//    }

    @Override
    public String toString() {
        return "\nPerfil{" +
                "id=" + id +
                ", tipoPerfil=" + tipoPerfil +
                '}';
    }
}
