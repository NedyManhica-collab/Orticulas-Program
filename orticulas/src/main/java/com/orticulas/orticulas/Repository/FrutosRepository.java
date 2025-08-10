package com.orticulas.orticulas.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orticulas.orticulas.modelClass.Frutos;

@Repository
public interface FrutosRepository  extends JpaRepository<Frutos, Long> {
     List<Frutos> findByNomePopularContainingIgnoreCaseAndNomeCientificoContainingIgnoreCase(String nomePopular, String nomeCientifico);
    
}
