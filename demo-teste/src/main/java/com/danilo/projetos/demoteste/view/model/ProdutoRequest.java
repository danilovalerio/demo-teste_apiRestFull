package com.danilo.projetos.demoteste.view.model;

/**
 * Requisicao de produtos que espero receber
 * Quando vamos cadastrar o ID não é importante
 */
public class ProdutoRequest {
    private String nome;
    private Integer quantidade;
    private Double valor;
    private String observacao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
