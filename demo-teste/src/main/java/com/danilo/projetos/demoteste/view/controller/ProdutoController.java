package com.danilo.projetos.demoteste.view.controller;

import com.danilo.projetos.demoteste.model.Produto;
import com.danilo.projetos.demoteste.services.ProdutoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * deixando somente @RestController a escuta será na raiz "/"
 */
@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    /**
     * Quando fizer um GetMapping para /produtos
     * @return Lista de todos os produtos
     */
    @GetMapping
    public List<Produto> obterTodos(){
        return produtoService.obterTodos();
    }

    /**
     * Vai escutar o verbo GET na URL api/produtos/id @PathVariable é o caminho da variavel
     * @param id id do produto que sera consultado
     * @return um Optional do Tipo Produto
     */
    @GetMapping("/{id}")
    public Optional<Produto> obterPorId(@PathVariable Integer id) {
        return produtoService.obterPorId(id);
    }

    /**
     * Adicionar um produto
     * @param produto que o spring tentará converter através de um binding
     * @return retorna o produto adicionado
     */
    @PostMapping
    public Produto adicionar(@RequestBody Produto produto){
        return produtoService.adicionar(produto);
    }

    /**
     * Vai escutar o verbo DELETE na URL api/produtos/id @PathVariable é o caminho da variavel
     * @param id id do produto que sera deletado
     * @return caso tenha sucesso retorna uma String
     */
    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Integer id) {
        produtoService.deletar(id);
        return "Produto com id: " + id + " foi deletado com sucesso!";
    }

    /**
     * Vai escutar o verbo DELETE na URL api/produtos/id @PathVariable é o caminho da variavel
     * @param id id do produto que sera deletado
     * @return caso tenha sucesso retorna uma String
     */
    @PutMapping("/{id}")
    public Produto atualizar(@RequestBody Produto produto, @PathVariable Integer id) {
        return produtoService.atualizar(id, produto);
    }
}
