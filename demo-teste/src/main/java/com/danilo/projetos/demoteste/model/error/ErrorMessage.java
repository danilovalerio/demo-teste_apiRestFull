package com.danilo.projetos.demoteste.model.error;

/**
 * Tem como responsabilidade retornar quando algum erro for lançado
 */
public class ErrorMessage {
    private String titulo;

    private Integer status;

    private String msg;

    public ErrorMessage(String titulo, Integer status, String msg) {
        this.titulo = titulo;
        this.status = status;
        this.msg = msg;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
