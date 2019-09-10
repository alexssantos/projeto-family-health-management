package com.seventeam.gsf.domain;

import com.seventeam.gsf.models.enums.EnumUsuarioPerfil;

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
    @Column(name = "tipo", unique = true, insertable = false)
    private EnumUsuarioPerfil tipoPerfil;


    // =======================
    // RELATIONSHIPS
    // =======================
    /* We also need to place the @OneToOne annotation here, too. That's because this is a bidirectional relationship.
     * The 'PERFIL' side of the relationship is called the non-owning side.
     */

    @OneToOne(mappedBy = "perfil")
    private Usuario usuario;


    // =======================
    // CONSTRUCTOR
    // =======================

	public Perfil() {}

	public Perfil(EnumUsuarioPerfil tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }


    // =======================
    // GET SET
    // =======================

    public EnumUsuarioPerfil getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(EnumUsuarioPerfil tipoPerfil) {
        this.tipoPerfil = tipoPerfil;
    }

}
