package br.com.dbc.vemser.pessoaapi.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ContatoCreateDTO {
    private Integer idPessoa;
    @NotBlank(message = "O campo número não pode ser nulo")
    @Size(min = 1, max = 13, message = "o campo número deve conter no máximo 13 caracteres")
    private String numero;
    @NotBlank (message = "O campo descrição não pode ser vazio")
    private String descricao;
}
