package com.orticulas.orticulas.modelClass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Estoque {

    @Id
    @Column(name = "ESTOQUE_ID")
    private Long id;
    @Column(name = "QUANTIDADE")
    private int quantidade;
    @Column(name = "DATA_ENTRADA")
    private String dataEntrada;
    @Column(name = "DATA_SAIDA")
    private String dataSaida;
    @Column(name = "OBSERVACOES")
    private String observacoes;
      @OneToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    public Estoque() {
    }
    public Estoque(Long id, int quantidade, String dataEntrada, String dataSaida, String observacoes) {
        this.id = id;
        this.quantidade = quantidade;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.observacoes = observacoes;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public String getDataEntrada() {
        return dataEntrada;
    }
    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
    public String getDataSaida() {
        return dataSaida;
    }
    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }
    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
}
