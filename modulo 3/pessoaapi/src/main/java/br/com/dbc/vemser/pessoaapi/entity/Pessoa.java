package br.com.dbc.vemser.pessoaapi.entity;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class Pessoa {
    @NotNull
    private Integer idPessoa;
    @NotEmpty(message = "O campo nome não pode ser vazio nem nulo")
    private String nome;
    @NotNull(message = "O campo data de nascimento não pode ser vazio")
    @Past
    private LocalDate dataNascimento;
    @NotEmpty(message = "O campo cpf não pode ser nulo nem vazio")
    @Size(min = 11, max = 11, message = "O campo cpf deve conter 11 caracteres")
    private String cpf;

    public Pessoa() {
    }

    public Pessoa(Integer idPessoa, String nome, LocalDate dataNascimento, String cpf) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "idPessoa=" + idPessoa +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
