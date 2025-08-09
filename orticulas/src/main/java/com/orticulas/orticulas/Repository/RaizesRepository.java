package com.orticulas.orticulas.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orticulas.orticulas.modelClass.Raizes;
@Repository
public interface RaizesRepository extends JpaRepository<Raizes, Long> {
     List<Raizes> findByNomePopularContainigIgnoreCaseNomeCientificoContainingIgnoreCase(String nomePopular, String nomeCientifico);
    
}
