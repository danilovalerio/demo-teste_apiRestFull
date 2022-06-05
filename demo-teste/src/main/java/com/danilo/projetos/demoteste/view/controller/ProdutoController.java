package com.danilo.projetos.demoteste.view.controller;

import com.danilo.projetos.demoteste.services.ProdutoService;
import com.danilo.projetos.demoteste.shared.ProdutoDTO;
import com.danilo.projetos.demoteste.view.model.ProdutoRequest;
import com.danilo.projetos.demoteste.view.model.ProdutoResponse;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     * @return Lista de todos os produtos com status code
     */
    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> obterTodos(){

        List<ProdutoDTO> produtosDtos = produtoService.obterTodos();

        ModelMapper mapper = new ModelMapper();

        List<ProdutoResponse> resposta = produtosDtos.stream()
                .map(produtoDTO -> mapper.map(produtoDTO, ProdutoResponse.class))
                .collect(Collectors.toList());

        return new ResponseEntity<>(resposta, HttpStatus.OK);
    }

    /**
     * Vai escutar o verbo GET na URL api/produtos/id @PathVariable é o caminho da variavel
     * @param id id do produto que sera consultado
     * @return um Optional do Tipo Produto
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProdutoResponse>> obterPorId(@PathVariable Integer id) {
        try {
            Optional<ProdutoDTO> dto = produtoService.obterPorId(id);
            ProdutoResponse produtoResponse = new ModelMapper().map(dto.get(), ProdutoResponse.class);
            return new ResponseEntity<>(
                    Optional.of(produtoResponse), HttpStatus.OK
            );
        } catch (Exception e){
            //Não retorna a excessão e devolve um body vazio
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    /**
     * Adicionar um produto
     * @param produtoReq que o spring tentará converter através de um binding
     * @return retorna o produto adicionado
     */
    @PostMapping
    public ResponseEntity<ProdutoResponse> adicionar(@RequestBody ProdutoRequest produtoReq){
        ModelMapper mapper = new ModelMapper();
        ProdutoDTO dto = mapper.map(produtoReq, ProdutoDTO.class);
        //Dto recebe os dados cadastrados
        dto = produtoService.adicionar(dto);

        return new ResponseEntity<>(mapper.map(dto, ProdutoResponse.class), HttpStatus.CREATED);
    }

    /**
     * Vai escutar o verbo DELETE na URL api/produtos/id @PathVariable é o caminho da variavel
     * @param id id do produto que sera deletado
     * @return caso tenha sucesso retorna uma ResponseEntity de qualquer coisa
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        produtoService.deletar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Vai escutar o verbo DELETE na URL api/produtos/id @PathVariable é o caminho da variavel
     * @param id id do produto que sera deletado
     * @return caso tenha sucesso retorna uma String
     */
    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizar(@RequestBody ProdutoRequest produtoReq, @PathVariable Integer id) {

        ModelMapper mapper = new ModelMapper();
        ProdutoDTO produtoDto = mapper.map(produtoReq, ProdutoDTO.class);

        //produtoDto recebe o que vier atualizado
        produtoDto = produtoService.atualizar(id, produtoDto);

        return new ResponseEntity<>(
                mapper.map(produtoDto, ProdutoResponse.class),
                HttpStatus.OK
        );
    }
}
