package br.com.dbc.vemser.pessoaapi.dto;

import br.com.dbc.vemser.pessoaapi.enums.TipoPet;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class PetCreateDTO {



    @Schema(description = "Nome do Pet")
    @NotEmpty(message = "O campo nome do Pet não pode ser vazio nem nulo")
    private String nome;

    @Schema(description = "Tipo de Pet")
    @NotNull(message = "O campo tipo de pet não pode ser nulo")
    private TipoPet tipo;
}
