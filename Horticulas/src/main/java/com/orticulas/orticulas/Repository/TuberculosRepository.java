package com.orticulas.orticulas.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orticulas.orticulas.modelClass.Tuberculos;
@Repository
public interface TuberculosRepository extends JpaRepository<Tuberculos, Long> {
    List<Tuberculos> findByNomePopularContainingIgnoreCaseAndNomeCientificoContainingIgnoreCase(String nomePopular, String nomeCientifico);
     
}
