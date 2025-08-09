package com.orticulas.orticulas.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orticulas.orticulas.modelClass.Folhosas;

@Repository
public interface FolhososRepository extends JpaRepository<Folhosas, Long> {
  
     List<Folhosas> findByNomePopularContainigIgnoreCaseNomeCientificoContainingIgnoreCase(String nomePopular, String nomeCientifico);
    
}
