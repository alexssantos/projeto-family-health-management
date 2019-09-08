package com.seventeam.gsf.domain;

import javax.persistence.*;

@Entity
@Table(name = "permissao")
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

//    @ManyToOne
//    @JoinColumn(name="usuario_id", nullable=false)
//    private Usuario usuario;


    private String acao;

}
