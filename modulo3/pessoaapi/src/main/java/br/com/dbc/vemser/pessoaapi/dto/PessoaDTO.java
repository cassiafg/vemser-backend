package br.com.dbc.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PessoaDTO extends PessoaCreateDTO{
    @Schema(description = "ID único da Pessoa")
    @NotNull
    private Integer idPessoa;
}
