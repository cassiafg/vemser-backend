package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PetDTO extends PetCreateDTO{
    @Schema(description = "Identificador único do pet")
    @NotNull(message = "O campo ID Pet não pode ser nulo")
    private Integer idPet;

    @Schema(description = "Identificador único da Pessoa")
    @NotNull(message = "O campo idPessoa não pode ser nulo")
    private Integer idPessoa;
}
