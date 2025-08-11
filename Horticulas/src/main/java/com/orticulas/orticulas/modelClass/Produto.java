package com.orticulas.orticulas.modelClass;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
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
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "URL_IMAGEM")
    private String UrlImagem;
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

}
