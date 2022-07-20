package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotNull;

public class PetDTO extends PetCreateDTO{
    @Schema(description = "Identificador único do pet")
    @NotNull(message = "O campo ID Pet não pode ser nulo")
    private Integer idPet;
}
