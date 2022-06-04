package com.danilo.projetos.demoteste.repository;

import com.danilo.projetos.demoteste.model.exception.ResourceNotFoundException;
import java.util.ArrayList;

import com.danilo.projetos.demoteste.model.Produto;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * interface generica que recebe dois parametros
 * um modelo @Produto e o tipo de id @Integer
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
