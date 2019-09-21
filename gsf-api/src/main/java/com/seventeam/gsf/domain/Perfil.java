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
    
//      FIXME: Erro Stackoverflow: 1 perfil -> M permissoes (cada) -> 1 Perfil -> N permissoes...
//    @OneToMany(
//            mappedBy = "perfil",
//            fetch = FetchType.EAGER,
//            cascade = CascadeType.ALL)
//    private List<Permissao> permissaoList = new ArrayList<>();


    // =======================
    // CONSTRUCTOR
    // =======================

	public Perfil() {}

	public Perfil(PerfilTipoEnum tipoPerfil) {
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
    
    @Override
    public String toString() {
        return "\nPerfil{" +
                "id=" + id +
                ", tipoPerfil=" + tipoPerfil +
                '}';
    }
}
