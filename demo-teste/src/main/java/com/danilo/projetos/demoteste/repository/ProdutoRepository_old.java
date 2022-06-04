package com.danilo.projetos.demoteste.repository;

import com.danilo.projetos.demoteste.model.Produto;
import com.danilo.projetos.demoteste.model.exception.ResourceNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 * injetando a dependencia no spring
 */
@Repository
public class ProdutoRepository_old {

    private ArrayList<Produto> produtos = new ArrayList<>();
    private Integer ultimoId = 0;

    /**
     * Metodo para retornar uma lista de produtos
     *
     * @return Lista de produtos.
     */
    public List<Produto> obterTodos() {
        return produtos;
    }

    /**
     * Metodo que retorna um Optional de Produto pelo seu id
     *
     * @param id id do produto procurado
     * @return retorna um Produto caso seja encontrado
     */
    public Optional<Produto> obterPorId(Integer id) {
        return produtos
                .stream()
                .filter(produto -> produto.getId() == id)
                .findFirst();
    }

    /**
     * Incrementa valor no ultimo id e adiciona produto na lista
     * @param produto que será adicionado
     * @return retorna produto adicionado na lista
     */
    public Produto adicionar(Produto produto) {
        ultimoId++;
        produto.setId(ultimoId);
        produtos.add(produto);

        return produto;
    }

    /**
     * Remove produto com o id informado
     * @param id Id do produto que será deletado
     */
    public void deletar(Integer id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }

    /**
     * Atualiza produto na lista
     * @param produto Produto a ser atualizado
     * @return produto atualizado
     */
    public Produto atualizar(Produto produto) {
        int indexOfProduct = produtos.indexOf(produto);

        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

        if (produtoEncontrado.isEmpty()) {
            throw new ResourceNotFoundException("Produto não encontrado");
        }

        deletar(produto.getId());
        produtos.add(produto);

        //produtos.set(indexOfProduct, produto);
        return produto;
    }

}
