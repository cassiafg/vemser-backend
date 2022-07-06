package br.com.dbc.vemser.pessoaapi.entity;

public class Contato {
    private Integer idContato;
    private Integer idPessoa;
    private String numero;
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
