package br.com.dbc.vemser.pessoaapi.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Endereco {
    private Integer idEndereco;
    private Integer idPessoa;
    @NotEmpty (message = "O campo logradouro não pode ser vazio")
    @Size(min = 1, max = 250, message = "o campo logradouro deve contar no máximo 250 caracteres")
    private String logradouro;
    @NotNull (message = "O campo logradouro não pode ser nulo")
    private Integer numero;
    private String complemento;
    @NotEmpty (message = "O campo cep não pode ser vazio")
    @Size(min = 1, max = 8, message = "o campo cep deve conter no máximo 250 caracteres")
    private String cep;
    @NotEmpty (message = "O campo cidade não pode ser vazio")
    @Size(min = 1, max = 250, message = "o campo cidade deve conter no máximo 250 caracteres")
    private String cidade;
    @NotNull (message = "O campo estado não pode ser nulo")
    private String estado;
    @NotNull (message = "O campo pais não pode ser nulo")
    private String pais;

    public Endereco(Integer idEndereco, Integer idPessoa, String logradouro, Integer numero, String complemento, String cep, String cidade, String estado, String pais) {
        this.idEndereco = idEndereco;
        this.idPessoa = idPessoa;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }
    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
