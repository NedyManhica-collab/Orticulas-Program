package com.orticulas.orticulas.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orticulas.orticulas.modelClass.Categoria;

@Repository
public interface  CategoriaRepository extends JpaRepository<Categoria, Long> {}
