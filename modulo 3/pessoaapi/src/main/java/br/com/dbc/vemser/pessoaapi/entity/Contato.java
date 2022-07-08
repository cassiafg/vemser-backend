package br.com.dbc.vemser.pessoaapi.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Contato {
    private Integer idContato;
    private Integer idPessoa;
    @NotBlank (message = "O campo número não pode ser nulo")
    @Size(min = 1, max = 13, message = "o campo número deve conter no máximo 13 caracteres")
    private String numero;
    @NotBlank (message = "O campo descrição não pode ser vazio")
    private String descricao;

    public Contato(){}

    public Contato(Integer idContato, Integer idPessoa, String numero, String descricao) {
        this.idContato = idContato;
        this.idPessoa = idPessoa;
        this.numero = numero;
        this.descricao = descricao;
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "idContato=" + idContato +
                ", idPessoa=" + idPessoa +
                ", numero='" + numero + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
