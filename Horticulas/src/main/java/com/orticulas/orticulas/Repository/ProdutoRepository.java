package com.orticulas.orticulas.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orticulas.orticulas.modelClass.Produto;



@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

List<Produto> findByNomePopularContainingIgnoreCaseAndNomeCientificoContainingIgnoreCase(String nomePopular, String nomeCientifico);
}

