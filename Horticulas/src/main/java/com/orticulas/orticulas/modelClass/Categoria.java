package com.orticulas.orticulas.modelClass;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categoria {

    @Id
    @Column(name = "CATEGORIA_ID")
    private Long  id;

    @Column(name = "NOME_CATEGORIA")
    private String nome;

    @Column(name = "DESCRICAO")
    private String descricao;

      @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Produto> produtos;

    
}
