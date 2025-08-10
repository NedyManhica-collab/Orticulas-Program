package com.orticulas.orticulas.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orticulas.orticulas.modelClass.CondimentosVerdes;

@Repository
public interface CondimentosRepository extends JpaRepository<CondimentosVerdes, Long> {
     List<CondimentosVerdes> findByNomePopularContainingIgnoreCaseAndNomeCientificoContainingIgnoreCase(String nomePopular, String nomeCientifico);
    
}
