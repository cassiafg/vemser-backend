package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EnderecoDTO extends EnderecoCreateDTO{
    @Schema(description = "Identificador único do endereço")
    @NotNull(message = "O campo ID Endereço não pode ser nulo")
    private Integer idEndereco;
}
