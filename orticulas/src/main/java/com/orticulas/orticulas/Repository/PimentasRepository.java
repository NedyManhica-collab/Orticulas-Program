package com.orticulas.orticulas.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orticulas.orticulas.modelClass.Pimentas;
@Repository
public interface PimentasRepository extends JpaRepository<Pimentas, Long> {
   
     List<Pimentas> findByNomePopularContainingIgnoreCaseAndNomeCientificoContainingIgnoreCase(String nomePopular, String nomeCientifico);
    
}
