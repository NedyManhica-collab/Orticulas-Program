package com.orticulas.orticulas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orticulas.orticulas.modelClass.Estoque;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {}
