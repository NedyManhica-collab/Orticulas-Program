package com.orticulas.orticulas.modelClass;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Base64;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Produto {

    @Id
    @Column(name = "NOME_DO_PRODUTO_ID")
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

    @ManyToOne
    @JoinColumn(name = "CATEGORIA_ID")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "FORNECEDOR_ID")
    private Fornecedor fornecedor;

    @OneToOne(mappedBy = "produto", cascade = CascadeType.ALL)
    private Estoque estoque;

    
    public Produto() {
    }
    public Produto(Long id, String nomePopular, String nomeCientifico, String descricao, byte[] imagem, BigDecimal preco, LocalDate dataColheita, String estado) {
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
    public String getBase64Imagem() {
        if (this.imagem != null) {
            return Base64.getEncoder().encodeToString(this.imagem);
        }
        return null;
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
