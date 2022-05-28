package com.danilo.projetos.demoteste.repository;

import java.util.ArrayList;

import com.danilo.projetos.demoteste.model.Produto;

import org.springframework.stereotype.Repository;

/**
 * injetando a dependencia no spring
 */
@Repository
public class ProdutoRepository {

    private ArrayList<Produto> produtos = new ArrayList<>();
    private Integer ultimoId = 0;

    
}
