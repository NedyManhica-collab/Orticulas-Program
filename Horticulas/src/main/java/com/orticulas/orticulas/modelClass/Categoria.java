package com.orticulas.orticulas.modelClass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Categoria {

    @Id
    @Column(name = "CATEGORIA_ID")
    private Long  id;

    @Column(name = "NOME_CATEGORIA")
    private String nome;

    @Column(name = "DESCRICAO")
    private String descricao;

    public Categoria() {
    }
    public Categoria(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
