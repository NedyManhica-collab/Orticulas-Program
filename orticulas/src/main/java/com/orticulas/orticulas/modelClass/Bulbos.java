package com.orticulas.orticulas.modelClass;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Bulbos {

    @Id
    @Column(name = "BULBOS_ID")
    private Long id;
    @Column(name = "NOME_POPULAR")
    private String nomePopular;
    @Column(name = "NOME_CIENTIFICO")
    private String nomeCientifico;
    @Lob
    @Column(name = "DESCRICAO")
    private String descricao;
    @Lob
    @Column(name = "IMAGEM")
    private byte[] imagem;
    @Column(name = "PRECO")
    private BigDecimal preco;
    @Column(name = "DATA_COLHEITA")
    private LocalDate dataColheita;
    @Column(name = "ESTADO")
    private String estado;
    
    public Bulbos() {
    }
    public Bulbos(Long id, String nomePopular, String nomeCientifico, String descricao, byte[] imagem, BigDecimal preco, LocalDate dataColheita, String estado) {
        this.id = id;
        this.nomePopular = nomePopular;
        this.nomeCientifico = nomeCientifico;
        this.descricao = descricao;
        this.imagem = imagem;
        this.preco = preco;
        this.dataColheita = dataColheita;
        this.estado = estado;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNomePopular() {
        return nomePopular;
    }
    public void setNomePopular(String nomePopular) {
        this.nomePopular = nomePopular;
    }
    public String getNomeCientifico() {
        return nomeCientifico;
    }
    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public byte[] getImagem() {
        return imagem;
    }
    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
    public BigDecimal getPreco() {
        return preco;
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    public LocalDate getDataColheita() {
        return dataColheita;
    }
    public void setDataColheita(LocalDate dataColheita) {
        this.dataColheita = dataColheita;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
