package br.com.dbc.vemser.pessoaapi.dto;

import lombok.Data;

@Data
public class DadosPessoaisDTO {

    private String cnh;
    private String cpf;
    private String nome;
    private String nomeMae;
    private String nomePai;
    private String rg;
    private Sexo sexo;
    private String tituloEleitor;
}
