package com.danilo.projetos.demoteste.services;

import com.danilo.projetos.demoteste.model.Produto;
import com.danilo.projetos.demoteste.model.exception.ResourceNotFoundException;
import com.danilo.projetos.demoteste.repository.ProdutoRepository;
import com.danilo.projetos.demoteste.shared.ProdutoDTO;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
    public List<ProdutoDTO> obterTodos(){
        //retorna uma lista de entidade produtos
        List<Produto> produtos = produtoRepository.findAll();

        /**
         * Percorre a lista de produtos e com o ModelMapper transforma em ProdutoDTO
         * usa um collector e transforma em uma lista
         */
        return produtos.stream().map(produto -> new ModelMapper().map(produto, ProdutoDTO.class))
                .collect(Collectors.toList());
    }

    /**
     * Metodo que retorna um Optional de Produto pelo seu id
     *
     * @param id id do produto procurado
     * @return retorna um Produto caso seja encontrado
     */
    public Optional<ProdutoDTO> obterPorId(Integer id) {
        // Obtem produto Optional de produto por id
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isEmpty()) {
            throw new ResourceNotFoundException("Produto com id: "+ id +" não encontrado");
        }

        //Converte Optional de Produto em Optional de ProdutoDto
        ProdutoDTO dto = new ModelMapper().map(produto.get(), ProdutoDTO.class);

        //Cria e retorna um Optional de dto
        return Optional.of(dto);
    }

    /**
     * Incrementa valor no ultimo id e adiciona produto na lista
     * @param produto que será adicionado
     * @return retorna produto adicionado na lista
     */
    public ProdutoDTO adicionar(ProdutoDTO produtoDto) {
        produtoDto.setId(null);

        //Criar um objeto de mapeamento

        //Converter o nosso produtoDTO em um Produto

        //Salvar o Produto no banco

        //Retornar o ProdutoDTO atualizado.

       return produtoRepository.save(produto);
    }

    /**
     * Remove produto com o id informado
     * @param id Id do produto que será deletado
     */
    public void deletar(Integer id) {
        //verificar se usuario tem permissao para deletar
        produtoRepository.deleteById(id);
    }

    /**
     * Atualiza produto na lista
     * @param id id do produto que será atualizado
     * @param produto Produto a ser atualizado
     * @return produto atualizado
     */
    public ProdutoDTO atualizar(Integer id, ProdutoDTO produtoDTO) {
        //ter alguma validacao no id
        produto.setId(id);
        return produtoRepository.save(produto);
    }
}
