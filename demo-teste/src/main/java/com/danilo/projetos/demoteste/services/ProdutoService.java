package com.danilo.projetos.demoteste.services;

import com.danilo.projetos.demoteste.model.Produto;
import com.danilo.projetos.demoteste.repository.ProdutoRepository;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    /**
     * Devolve uma instancia de ProdutoRepository para nosso controle
     * não precisando que crie uma instância
     */
    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Metodo para retornar uma lista de produtos
     *
     * @return Lista de produtos.
     */
    public List<Produto> obterTodos(){
        //Aqui vem a regra caso tenha
        return produtoRepository.obterTodos();
    }

    /**
     * Metodo que retorna um Optional de Produto pelo seu id
     *
     * @param id id do produto procurado
     * @return retorna um Produto caso seja encontrado
     */
    public Optional<Produto> obterPorId(Integer id) {
        //valida se id existe mesmo ou não
        return produtoRepository.obterPorId(id);
    }

    /**
     * Incrementa valor no ultimo id e adiciona produto na lista
     * @param produto que será adicionado
     * @return retorna produto adicionado na lista
     */
    public Produto adicionar(Produto produto) {
        //regra para validar produto, qtd maior que 0 por exemplo, voltagem diferente de vazio
       return produtoRepository.adicionar(produto);
    }

    /**
     * Remove produto com o id informado
     * @param id Id do produto que será deletado
     */
    public void deletar(Integer id) {
        //verificar se usuario tem permissao para deletar
        produtoRepository.deletar(id);
    }

    /**
     * Atualiza produto na lista
     * @param id id do produto que será atualizado
     * @param produto Produto a ser atualizado
     * @return produto atualizado
     */
    public Produto atualizar(Integer id, Produto produto) {
        //ter alguma validacao no id
        produto.setId(id);
        return produtoRepository.atualizar(produto);
    }
}
