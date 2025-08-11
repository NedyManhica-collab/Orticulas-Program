package com.orticulas.orticulas.modelClass;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
 
}
