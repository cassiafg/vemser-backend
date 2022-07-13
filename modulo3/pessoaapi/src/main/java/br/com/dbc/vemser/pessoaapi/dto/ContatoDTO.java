package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ContatoDTO extends ContatoCreateDTO{
    @Schema(description = "ID único do contato")
    @NotNull
    private Integer idContato;
}
